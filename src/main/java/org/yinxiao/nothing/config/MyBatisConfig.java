package org.yinxiao.nothing.config;

/**
 * @Title: MyBatisConfig
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.config
 * @Date: 2025/4/20 16:39
 */


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis 配置类，扫描 Mapper 接口
 */
@Configuration
@MapperScan("org.yinxiao.nothing.mapper")
public class MyBatisConfig {
}    