package org.yinxiao.nothing.service;

/**
 * @Title: SocialTideFactorIndicatorService
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.service
 * @Date: 2025/4/20 17:11
 */
import org.yinxiao.nothing.entity.SocialTideFactorIndicator;

import java.util.List;

/**
 * 社会潮汐因子指标服务接口，定义相关的业务逻辑方法
 */
public interface SocialTideFactorIndicatorService {
    /**
     * 批量插入社会潮汐因子指标数据
     * @param indicators 社会潮汐因子指标列表
     * @return 受影响的行数
     */
    int batchInsert(List<SocialTideFactorIndicator> indicators);

    /**
     * 根据证件号删除社会潮汐因子指标数据
     * @param certificateNumber 证件号
     * @return 受影响的行数
     */
    int deleteByCertificateNumber(String certificateNumber);

    /**
     * 根据证件号修改社会潮汐因子指标数据
     * @param indicator 社会潮汐因子指标对象
     * @return 受影响的行数
     */
    int updateByCertificateNumber(SocialTideFactorIndicator indicator);

    /**
     * 根据证件号查询社会潮汐因子指标数据
     * @param certificateNumber 证件号
     * @return 社会潮汐因子指标列表
     */
    List<SocialTideFactorIndicator> selectByCertificateNumber(String certificateNumber);

    /**
     * 查询所有社会潮汐因子指标数据，支持分页
     * @param page 页码
     * @return 社会潮汐因子指标列表
     */
    List<SocialTideFactorIndicator> selectAll(int page);
}
