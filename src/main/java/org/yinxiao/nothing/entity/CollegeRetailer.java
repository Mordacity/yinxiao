package org.yinxiao.nothing.entity;

/**
 * @Title: CollegeRetailer
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.entity
 * @Date: 2025/4/20 16:39
 */

import lombok.Data;

// 高校零售户实体类，对应数据库中的 college_retailer 表
@Data
public class CollegeRetailer {
    // 自增 ID
    private Integer id;
    // 证件号，关联 cigarette_retailer_info 表的 certificate_number 字段
    private String certificateNumber;
    // 高校名称，长度为 16
    private String universityName;
}