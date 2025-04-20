package org.yinxiao.nothing.service;

/**
 * @Title: CollegeTideFactorIndicatorService
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.service
 * @Date: 2025/4/20 16:39
 */

import org.yinxiao.nothing.entity.CollegeTideFactorIndicator;

import java.util.List;

/**
 * 高校潮汐因子指标服务接口，定义相关的业务逻辑方法
 */
public interface CollegeTideFactorIndicatorService {
    /**
     * 批量插入高校潮汐因子指标数据
     * @param indicators 高校潮汐因子指标列表
     * @return 插入成功的记录数
     */
    int batchInsert(List<CollegeTideFactorIndicator> indicators);

    /**
     * 根据证件号和ID删除高校潮汐因子指标数据
     * @param certificateNumber 证件号
     * @return 删除成功的记录数
     */
    int deleteByCertificateNumber(String certificateNumber,Integer id);

    /**
     * 根据证件号和ID修改高校潮汐因子指标数据
     * @param indicator 高校潮汐因子指标对象
     * @return 修改成功的记录数
     */
    int updateByCertificateNumber(CollegeTideFactorIndicator indicator);

    /**
     * 根据证件号查询高校潮汐因子指标数据
     * @param certificateNumber 证件号
     * @return 高校潮汐因子指标列表
     */
    List<CollegeTideFactorIndicator> getByCertificateNumber(String certificateNumber);

    /**
     * 分页查询所有高校潮汐因子指标数据
     * @param page 页码
     * @return 高校潮汐因子指标列表
     */
    List<CollegeTideFactorIndicator> getAll(int page);
}