package org.yinxiao.nothing.entity;

/**
 * @Title: SocialTideFactorIndicator
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.entity
 * @Date: 2025/4/20 17:09
 */
import lombok.Data;

import java.util.Date;
/**
 * 社会潮汐因子指标实体类，对应数据库中的 social_tide_factor_indicator 表
 */
@Data
public class SocialTideFactorIndicator {
    private Integer id; // 自增 ID
    private String certificateNumber; // 证件号，关联 cigarette_retailer_info 表的 certificate_number 字段
    private String communityName; // 社区名称，长度为8
    private String residentPopulation; // 常住人口数量，长度为 32
    private String smokingRate; // 吸烟率，长度为 8
    private String geographicalWeight; // 地理权重，长度为 4
    private Date dataDate; // 数据时间
}
