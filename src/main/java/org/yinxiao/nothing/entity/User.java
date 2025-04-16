package org.yinxiao.nothing.entity;

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