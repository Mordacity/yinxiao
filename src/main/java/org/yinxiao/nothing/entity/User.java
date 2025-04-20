package org.yinxiao.nothing.entity;

/**
 * @Title: User
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.entity
 * @Date: 2025/4/20 16:39
 */

import lombok.Data;

/**
 * 用户实体类，对应数据库中的 user 表
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
}    