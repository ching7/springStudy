package com.cyn.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot-exception
 * @Package: com.cyn.exception
 * @Description:
 *
 * 通过SimpleMappingExceptionResolver 实现全局异常处理
 *
 * @CreateDate: 2019/10/11 10:57
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 **/
@Configuration
public class GlobalException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        if (e instanceof ArithmeticException){
            mv.setViewName("errorArithmetic");
        }
        if (e instanceof NullPointerException) {
            mv.setViewName("errorNullpointer");
        }
        mv.addObject("error",e.toString());
        return mv;
    }
}
