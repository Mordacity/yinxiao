package org.yinxiao.nothing.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis 配置类，扫描 Mapper 接口
 */
@Configuration
@MapperScan("org.yinxiao.nothing.mapper")
public class MyBatisConfig {
}    