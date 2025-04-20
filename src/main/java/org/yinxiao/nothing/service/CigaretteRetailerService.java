package org.yinxiao.nothing.service;

import org.yinxiao.nothing.entity.CigaretteRetailer;

import java.util.List;

public interface CigaretteRetailerService {
    // 添加卷烟零售户信息
    int addRetailer(CigaretteRetailer retailer);

    // 根据 UUID 删除卷烟零售户信息
    int deleteRetailer(String uuid);

    // 修改卷烟零售户信息
    int updateRetailer(CigaretteRetailer retailer);

    // 根据 UUID 查询卷烟零售户信息
    CigaretteRetailer getRetailerByUuid(String uuid);

    // 查询所有卷烟零售户信息
    List<CigaretteRetailer> getAllRetailers();
}