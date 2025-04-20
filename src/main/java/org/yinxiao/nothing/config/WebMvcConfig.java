package org.yinxiao.nothing.config;

/**
 * @Title: WebMvcConfig
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.config
 * @Date: 2025/4/20 16:39
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.yinxiao.nothing.interceptor.TokenInterceptor;

/**
 * Spring MVC 配置类，注册 Token 拦截器
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    // 注入 Token 拦截器
    @Autowired
    private TokenInterceptor tokenInterceptor;

    // 添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加 Token 拦截器，拦截 /user/** 路径下的请求，排除 /user/login 路径下的请求
        registry.addInterceptor(tokenInterceptor)
               .addPathPatterns("/user/**")
               .excludePathPatterns("/user/login","/user/add")
               ;
    }
}    