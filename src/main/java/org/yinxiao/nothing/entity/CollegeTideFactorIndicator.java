package org.yinxiao.nothing.entity;

/**
 * @Title: CollegeTideFactorIndicator
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.entity
 * @Date: 2025/4/20 16:39
 */


import lombok.Data;

import java.util.Date;

/**
 * 高校潮汐因子指标实体类，对应数据库中的 college_tide_factor_indicator 表
 */
@Data
public class CollegeTideFactorIndicator {
    private Integer id; // 自增 ID
    private String certificateNumber; // 证件号
    private String universityName; // 高校名称
    private String residentPopulation; // 常住人口数量
    private String currentSemesterStudents; // 该学期学生数
    private String holidayStayingRate; // 寒暑假留校率
    private String smokingRate; // 吸烟率
    private String geographicalWeight; // 地理权重
    private Date dataDate; // 数据时间
}