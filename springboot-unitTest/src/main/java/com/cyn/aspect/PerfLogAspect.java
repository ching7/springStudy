package com.cyn.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cyn.annotation.PerfLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

@Aspect
@Component
public class PerfLogAspect {

    private static final Logger LOG = LoggerFactory.getLogger(PerfLogAspect.class);

    private static final Logger PERF_LOG = LoggerFactory.getLogger("PERF_LOG");

    @Pointcut("@annotation(com.cyn.annotation.PerfLog)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long st = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - st;
        // 打印日志
        printSysLog(point, time, result);
        return result;
    }

    private void printSysLog(ProceedingJoinPoint point, long time, Object result) {
        try {
            MethodSignature signature = (MethodSignature) point.getSignature();
            Method method = signature.getMethod();
            PerfLog perfLog = method.getAnnotation(PerfLog.class);
            String className = point.getTarget().getClass().getName();
            String methodName = signature.getName();
            Object[] args = point.getArgs();
            if (!StringUtils.isEmpty(perfLog.value())) {
                PERF_LOG.info("operate : {}", perfLog.value());
            }
            PERF_LOG.info("request method : {}", className + "." + methodName + "()");
            if (null != args && args.length != 0) {
                try {
                    PERF_LOG.info("request-0 params : {}", JSON.toJSONString(args, SerializerFeature.IgnoreNonFieldGetter));
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    for (Object object : args) {
                        if (null != object)
                            sb.append(object.toString()).append(",");
                    }
                    PERF_LOG.info("request-1 params : {}", sb.toString());
                }
            }
            PERF_LOG.info("request time : {}ms", time);
            try {
                PERF_LOG.info("request return : {}", result);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            LOG.error("printSysLog error:", e);
        }
    }

}
