package org.yinxiao.nothing.mapper;

/**
 * @Title: PublicIndicatorInfoMapper
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.mapper
 * @Date: 2025/4/20 16:39
 */

import org.apache.ibatis.annotations.Mapper;
import org.yinxiao.nothing.entity.PublicIndicatorInfo;

import java.util.List;

/**
 * 公共指标数据数据访问接口，定义公共指标数据相关的数据库操作方法
 */
@Mapper
public interface PublicIndicatorInfoMapper {
    /**
     * 批量添加公共指标数据信息
     * @param publicIndicatorInfos 公共指标数据列表
     * @return 受影响的行数
     */
    int addPublicIndicatorInfos(List<PublicIndicatorInfo> publicIndicatorInfos);

    /**
     * 根据证件号删除公共指标数据信息
     * @param certificateNumber 证件号
     * @return 受影响的行数
     */
    int deletePublicIndicatorInfo(String certificateNumber);

    /**
     * 根据证件号修改公共指标数据信息
     * @param publicIndicatorInfo 公共指标数据信息
     * @return 受影响的行数
     */
    int updatePublicIndicatorInfo(PublicIndicatorInfo publicIndicatorInfo);

    /**
     * 根据证件号查询公共指标数据信息
     * @param certificateNumber 证件号
     * @return 公共指标数据信息列表
     */
    List<PublicIndicatorInfo> getPublicIndicatorInfoByCertificateNumber(String certificateNumber);

    /**
     * 分页查询所有公共指标数据信息
     * @param offset 偏移量
     * @param limit 每页数量
     * @return 公共指标数据信息列表
     */
    List<PublicIndicatorInfo> getAllPublicIndicatorInfos(int offset, int limit);
}