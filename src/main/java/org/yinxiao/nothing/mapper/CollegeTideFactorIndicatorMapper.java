package org.yinxiao.nothing.mapper;

/**
 * @Title: CollegeTideFactorIndicatorMapper
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.mapper
 * @Date: 2025/4/20 16:39
 */

import org.apache.ibatis.annotations.Mapper;
import org.yinxiao.nothing.entity.CollegeTideFactorIndicator;

import java.util.List;

/**
 * 高校潮汐因子指标数据访问接口，定义相关的数据库操作方法
 */
@Mapper
public interface CollegeTideFactorIndicatorMapper {
    /**
     * 批量插入高校潮汐因子指标数据
     * @param indicators 高校潮汐因子指标列表
     * @return 插入成功的记录数
     */
    int batchInsert(List<CollegeTideFactorIndicator> indicators);

    /**
     * 根据证件号删除高校潮汐因子指标数据
     * @param certificateNumber 证件号
     * @return 删除成功的记录数
     */
    int deleteByCertificateNumber(String certificateNumber);

    /**
     * 根据证件号修改高校潮汐因子指标数据
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
     * @param offset 偏移量
     * @param limit 每页记录数
     * @return 高校潮汐因子指标列表
     */
    List<CollegeTideFactorIndicator> getAll(int offset, int limit);
}