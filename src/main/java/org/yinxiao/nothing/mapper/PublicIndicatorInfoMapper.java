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
     * 批量插入公共指标数据
     * @param publicIndicatorInfos 公共指标数据列表
     * @return 受影响的行数
     */
    int batchInsert(List<PublicIndicatorInfo> publicIndicatorInfos);

    /**
     * 根据证件号和 ID 删除公共指标数据
     * @param certificateNumber 证件号
     * @param id 自增 ID
     * @return 受影响的行数
     */
    int deleteByCertificateNumberAndId(String certificateNumber, Integer id);

    /**
     * 根据证件号和 ID 修改公共指标数据
     * @param publicIndicatorInfo 公共指标数据对象
     * @return 受影响的行数
     */
    int updateByCertificateNumberAndId(PublicIndicatorInfo publicIndicatorInfo);

    /**
     * 根据证件号查询公共指标数据
     * @param certificateNumber 证件号
     * @return 公共指标数据列表
     */
    List<PublicIndicatorInfo> getByCertificateNumber(String certificateNumber);

    /**
     * 查询所有公共指标数据，分页查询
     * @param offset 偏移量
     * @param limit 每页数量
     * @return 公共指标数据列表
     */
    List<PublicIndicatorInfo> getAll(int offset, int limit);
}