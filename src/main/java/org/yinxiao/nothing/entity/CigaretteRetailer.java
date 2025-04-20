package org.yinxiao.nothing.entity;

/**
 * @Title: CigaretteRetailer
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.entity
 * @Date: 2025/4/20 16:39
 */

import lombok.Data;

// 卷烟零售商实体类，对应数据库中的 cigarette_retailer_info 表
@Data
public class CigaretteRetailer {
    // 自增 ID
    private Integer id;
    // 证件号，长度为 32，不能重复
    private String certificateNumber;
    // 店铺名称，长度为 64
    private String shopName;
    // 店铺负责人，长度为 8
    private String shopOwner;
}