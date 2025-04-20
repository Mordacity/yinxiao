package org.yinxiao.nothing.config;

/**
 * @Title: SwaggerConfig
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.config
 * @Date: 2025/4/20 16:39
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
               .select()
               .apis(RequestHandlerSelectors.basePackage("org.yinxiao.nothing.controller"))
               .paths(PathSelectors.any())
               .build()
               .apiInfo(apiInfo())
               .pathMapping("/"); // 明确指定基础 URL
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
               .title("用户管理 API 文档")
               .description("用户管理相关接口文档")
               .version("1.0.0")
               .build();
    }
}    