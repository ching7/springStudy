package com.cyn.aspect;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;

@Aspect
@ConditionalOnProperty(value = "app.trace", havingValue = "true")
@Component
public class TranceLog implements ApplicationListener<ContextRefreshedEvent> {
    private boolean init = false;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent ev) {
        //防止重复执行。
        if (ev.getApplicationContext().getParent() == null) {
            init = true;
        }
    }

    @Autowired
    private TranceLog tranceLog;

    @Value("${app.trace.print:#{null}}")
    private HashSet<String> debugPrint;

    @Value("${app.trace.exclude:#{null}}")
    private ArrayList<String> traceExclude;

    Logger logger = LoggerFactory.getLogger("com.cyn.aspect.TranceLog");

    HashMap<Long, List<Trace>> traceHashMap = new HashMap<>();

    /**
     * service
     */
    @Pointcut(value = "execution(* com.cyn.service.*.*(..))")
    public void service() {
    }

    /**
     * controller
     */
    @Pointcut(value = "execution(* com.cyn.controller.*.*(..))")
    public void controller() {
    }

    /**
     * db
     */
//    @Pointcut(value = "execution(* com.baomidou.mybatisplus.core.mapper.BaseMapper.*(..))")
//    public void db() {
//    }

    @Around(value = "service()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        return mAround(joinPoint);
    }

    @Around(value = "controller()")
    public Object around2(ProceedingJoinPoint joinPoint) throws Throwable {
        return mAround(joinPoint);
    }

    //    @Around(value = "db()")
    public Object around3(ProceedingJoinPoint joinPoint) throws Throwable {
        return mAround(joinPoint);
    }


    public Object mAround(ProceedingJoinPoint joinPoint) throws Throwable {
        if (!init) {
            return joinPoint.proceed();
        }
        long id = Thread.currentThread().getId();
        if (!traceHashMap.containsKey(id)) {
            traceHashMap.put(id, new ArrayList());
        }
        String pack = joinPoint.getSignature().toString();
        String[] ret = pack.split(" ");
        String[] ps = ret[1].split("[.]");
        String signature = String.format("%s %s.%s", ret[0], ps[ps.length - 2], ps[ps.length - 1]);
        String params = JSONUtil.toJsonStr(joinPoint.getArgs());
        traceHashMap.get(id).add(
                new Trace(Thread.currentThread().getStackTrace().length, signature, params, null, null));

        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();//执行------------->

        long end = System.currentTimeMillis();
        String duration = String.format("%s%s", (end - start), "ms");
        String returnStr = null;
        if (proceed instanceof Boolean) {
            returnStr = JSONUtil.toJsonStr(proceed + "");//如果是Boolean型无法转换json
        } else {
            returnStr = JSONUtil.toJsonStr(proceed);
        }

        traceHashMap.get(id).add(
                new Trace(Thread.currentThread().getStackTrace().length, null, null, duration, returnStr));
        synchronized (traceHashMap) {
            if ((traceHashMap.get(id).get(0).getIndex() == CollectionUtil.getLast(traceHashMap.get(id)).getIndex())) {
                List<Trace> traces = traceHashMap.remove(id);

                if (CollectionUtil.isNotEmpty(traceExclude)) {
                    String method = ps[ps.length - 2] + "." + ps[ps.length - 1].substring(0,ps[ps.length - 1].indexOf("("));
                    for (String exclude : traceExclude) {
                        String[] excludeSplit = exclude.split("[.]");
                        if(excludeSplit[0].equals("*")){//左边* 匹配右侧
                            if (method.endsWith(excludeSplit[1])) {
                                return proceed;
                            }
                        }

                        if(excludeSplit[1].equals("*")){//右边* 匹配左侧
                            if (method.startsWith(excludeSplit[0])) {
                                return proceed;
                            }
                        }

                        if(exclude.equals(method)){//全匹配
                            return proceed;
                        }

                    }
                }

                logger.info("");
                logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                int dir = -1;
                Set<Integer> printed = new HashSet<>();
                for (int i = 0; i < traces.size(); i++) {
                    Trace up = traces.get(i);
                    if (up.getParams() != null) {
                        String space = tranceLog.getSpace(up.getIndex() - traces.get(0).getIndex());
                        if (CollectionUtil.isNotEmpty(debugPrint) && (debugPrint.contains("m") || debugPrint.contains("method"))) {
                            logger.info(space + "m:" + up.getSignature());
                        }
                        if (CollectionUtil.isNotEmpty(debugPrint) && (debugPrint.contains("p") || debugPrint.contains("params"))) {
                            if (up.getParams().length() != 2) {
                                logger.info(space + "p:" + up.getParams());
                            }
                        }
                    }

                    if ((dir > up.getIndex() || dir == up.getIndex()) && up.getDuration() != null) {
                        Trace down = traces.get(i);
                        printed.add(down.getIndex());
                        String resSpace = tranceLog.getSpace(down.getIndex() - traces.get(0).getIndex());
                        if (CollectionUtil.isNotEmpty(debugPrint) && (debugPrint.contains("r") || debugPrint.contains("return"))) {
                            logger.info(resSpace + "r:" + down.getDuration() + " " + down.getRes());
                        }
                    }
                    dir = up.getIndex();
                }
                if (traces.size() != 2) {
                    logger.info("");
                }

                for (int i = 0; i < traces.size(); i++) {
                    Trace down = traces.get(i);
                    if (!printed.contains(down.getIndex())) {
                        String space = tranceLog.getSpace(down.getIndex() - traces.get(0).getIndex());
                        if (CollectionUtil.isNotEmpty(debugPrint) && (debugPrint.contains("r") || debugPrint.contains("return"))) {
                            logger.info(space + "r:" + down.getDuration() + " " + down.getRes());
                        }
                    }
                }
                logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                logger.info("");
            }
        }
        return proceed;
    }

    public String getSpace(int size) {
        String res = "";
        for (int i = 0; i < size; i++) {
            res += " ";
        }
        return res;
    }

    class Trace implements Serializable {
        private int index;
        private String signature;
        private String params;
        private String duration;
        private String res;

        public Trace(int index, String signature, String params, String duration, String res) {
            this.index = index;
            this.signature = signature;
            this.params = params;
            this.duration = duration;
            this.res = res;
        }

        public int getIndex() {
            return index;
        }

        public String getSignature() {
            return signature;
        }

        public String getParams() {
            return params;
        }

        public String getDuration() {
            return duration;
        }

        public String getRes() {
            return res;
        }
    }
}
