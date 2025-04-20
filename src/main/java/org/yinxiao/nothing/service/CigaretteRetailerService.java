package org.yinxiao.nothing.service;

/**
 * @Title: CigaretteRetailerService
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.service
 * @Date: 2025/4/20 16:39
 */


import org.yinxiao.nothing.entity.CigaretteRetailer;

import java.util.List;

// 卷烟零售商服务接口，定义业务逻辑方法
public interface CigaretteRetailerService {
    // 批量插入卷烟零售商信息
    int batchAddRetailers(List<CigaretteRetailer> retailers);
    // 根据证件号删除卷烟零售商信息
    int deleteRetailerByCertificateNumber(String certificateNumber);
    // 根据证件号修改卷烟零售商信息
    int updateRetailerByCertificateNumber(CigaretteRetailer retailer);
    // 根据证件号查询卷烟零售商信息
    CigaretteRetailer getRetailerByCertificateNumber(String certificateNumber);
    // 分页查询所有卷烟零售商信息，每页 15 条数据
    List<CigaretteRetailer> getAllRetailers(int page);
}