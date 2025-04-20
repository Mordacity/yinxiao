package org.yinxiao.nothing.service;

/**
 * @Title: PublicIndicatorInfoService
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.service
 * @Date: 2025/4/20 16:39
 */

import org.yinxiao.nothing.entity.PublicIndicatorInfo;

import java.util.List;

/**
 * 公共指标数据服务接口，定义公共指标数据相关的业务逻辑方法
 */
public interface PublicIndicatorInfoService {
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
     * @param page 页码
     * @return 公共指标数据列表
     */
    List<PublicIndicatorInfo> getAll(int page);
}