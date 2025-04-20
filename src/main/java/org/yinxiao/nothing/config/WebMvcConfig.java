package org.yinxiao.nothing.config;

/**
 * @Title: WebMvcConfig
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.config
 * @Date: 2025/4/20 16:39
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.yinxiao.nothing.filter.XSSFilter;
import org.yinxiao.nothing.interceptor.TokenInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Autowired
    private XSSFilter xssFilter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/user/**")
                .excludePathPatterns("/user/login","/user/add");
    }

    @Bean
    public FilterRegistrationBean<XSSFilter> xssFilterRegistration() {
        FilterRegistrationBean<XSSFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(xssFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }
}