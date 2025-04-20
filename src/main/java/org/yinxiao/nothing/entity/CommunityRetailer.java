package org.yinxiao.nothing.entity;

/**
 * @Title: CommunityRetailer
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.entity
 * @Date: 2025/4/20 16:39
 */

import lombok.Data;

/**
 * 社区零售户实体类，对应数据库中的 community_retailer 表
 */
@Data
public class CommunityRetailer {
    private Integer id; // 自增 ID
    private String certificateNumber; // 证件号
    private String communityName; // 社区名称
}