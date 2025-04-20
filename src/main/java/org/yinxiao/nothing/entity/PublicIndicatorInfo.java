package org.yinxiao.nothing.entity;

/**
 * @Title: PublicIndicatorInfo
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.entity
 * @Date: 2025/4/20 16:39
 */

import lombok.Data;

import java.util.Date;

/**
 * 公共指标数据实体类，对应数据库中的 public_indicator_info 表
 */
@Data
public class PublicIndicatorInfo {
    private Integer id; // 自增 ID
    private String certificateNumber; // 证件号
    private String studentSpecRatio; // 学生品规占比
    private String geographicalWeight; // 地理权重
    private String salesIntensityCoefficient; // 销售强度系数
    private String weeklySales; // 周销量
    private Integer gearCoefficient; // 档位系数
    private Integer serviceRequestCount; // 寻求服务次数
    private Integer abnormalSalesCount; // 销售异常次数
    private String inventorySalesRatio; // 存销比
    private String fullOrderRateFluctuation; // 订足率波动
    private Date dataDate; // 数据日期
}