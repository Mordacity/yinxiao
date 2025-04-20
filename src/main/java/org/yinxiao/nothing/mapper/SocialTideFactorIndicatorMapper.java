package org.yinxiao.nothing.mapper;

/**
 * @Title: SocialTideFactorIndicatorMapper
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.mapper
 * @Date: 2025/4/20 17:10
 */
import org.apache.ibatis.annotations.Mapper;
import org.yinxiao.nothing.entity.SocialTideFactorIndicator;

import java.util.List;

/**
 * 社会潮汐因子指标数据访问接口，定义相关的数据库操作方法
 */
@Mapper
public interface SocialTideFactorIndicatorMapper {
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
     * @param offset 偏移量
     * @param limit 每页数量
     * @return 社会潮汐因子指标列表
     */
    List<SocialTideFactorIndicator> selectAll(int offset, int limit);
}
