package org.example.config;

import com.iflytek.sec.uap.client.rest.filter.AuthenticationFilter;
import com.iflytek.sec.uap.client.rest.filter.Cas20ProxyReceivingTicketValidationFilter;
import com.iflytek.sec.uap.client.rest.filter.DecisionFilter;
import com.iflytek.sec.uap.client.rest.filter.FilterChainProxy;
import com.iflytek.sec.uap.client.rest.listener.SpringStartListener;
import com.iflytek.sec.uap.util.RestClientUtil;
import com.iflytek.sec.uap.util.SpringContextUtil;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UapConfig
 * @Description
 * @Author ynchen
 * @Date 2023/4/13 16:04
 * @Version V1.0.0
 */
@Configuration
@Component
public class FilterConfig {

    @Value("${cas.server.context}")
    private String serverContext;

    @Value("${cas.server.login:login}")
    private String serverLogin;

    @Value("${cas.client.context}")
    private String clientContext;

    @Bean
    public SpringContextUtil springContextUtil(ApplicationContext applicationContext) {
        SpringContextUtil springContextUtil = new SpringContextUtil();
        springContextUtil.setApplicationContext(applicationContext);
        return springContextUtil;
    }
    //初始化应用的所有资源和所有认证后访问的资源启动bean
    @Bean
    public SpringStartListener springStartListener() {
        return new SpringStartListener();
    }

    //注册UAP filter
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    @DependsOn({"memoryConfigUtil", "memoryConfig", "springContextUtil"})
    public FilterRegistrationBean uapFilterRegistration() {
        // 负责对请求进行登录验证拦截
        AuthenticationFilter authenticationFilter = new AuthenticationFilter();
        authenticationFilter.setCasServerLoginUrl(serverContext + serverLogin);
        authenticationFilter.setServerName(clientContext);

        // 负责对请求参数ticket进行验证
        Cas20ProxyReceivingTicketValidationFilter validationFilter = new Cas20ProxyReceivingTicketValidationFilter();
        validationFilter.setServerName(clientContext);
        validationFilter.setRedirectAfterValidation(true);

        // 支持getUserPrincipal，getRemoteUser方法来取得用户信息
        HttpServletRequestWrapperFilter httpServletRequestWrapperFilter = new HttpServletRequestWrapperFilter();

        // 访问决策
        DecisionFilter decisionFilter = new DecisionFilter();

        // 过滤器链代理初始化
        FilterChainProxy uapClientFilter = new FilterChainProxy();
        uapClientFilter.setHttpServletRequestWrapperFilter(httpServletRequestWrapperFilter);
        uapClientFilter.setValidationFilter(validationFilter);
        uapClientFilter.setAuthenticationFilter(authenticationFilter);
        uapClientFilter.setDecisionFilter(decisionFilter);

        // 启用redis或者内存
        /*if (sessionStoreType.equals("redis")) {
            ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
            RedisSessionMappingStorage sessionMappingStorage = (RedisSessionMappingStorage) applicationContext.getBean("sessionMappingStorage");
            uapClientFilter.setSessionMappingStorage(sessionMappingStorage);
        }*/

        // 注册过滤器链代理
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(uapClientFilter);
        registration.setName("uapClientFilter");
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("targetFilterLifecycle", "true");
        registration.setInitParameters(initParameters);
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }

}