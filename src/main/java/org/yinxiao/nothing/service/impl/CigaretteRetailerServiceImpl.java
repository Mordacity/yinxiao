package org.yinxiao.nothing.service.impl;

/**
 * @Title: CigaretteRetailerMapper
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.service.impl
 * @Date: 2025/4/20 16:39
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yinxiao.nothing.entity.CigaretteRetailer;
import org.yinxiao.nothing.mapper.CigaretteRetailerMapper;
import org.yinxiao.nothing.service.CigaretteRetailerService;

import java.util.List;

// 卷烟零售商服务实现类，实现业务逻辑方法
@Service
public class CigaretteRetailerServiceImpl implements CigaretteRetailerService {

    // 注入 CigaretteRetailerMapper 实例
    @Autowired
    private CigaretteRetailerMapper cigaretteRetailerMapper;

    // 批量插入卷烟零售商信息
    @Override
    public int batchAddRetailers(List<CigaretteRetailer> retailers) {
        return cigaretteRetailerMapper.batchAddRetailers(retailers);
    }

    // 根据证件号删除卷烟零售商信息
    @Override
    public int deleteRetailerByCertificateNumber(String certificateNumber) {
        return cigaretteRetailerMapper.deleteRetailerByCertificateNumber(certificateNumber);
    }

    // 根据证件号修改卷烟零售商信息
    @Override
    public int updateRetailerByCertificateNumber(CigaretteRetailer retailer) {
        return cigaretteRetailerMapper.updateRetailerByCertificateNumber(retailer);
    }

    // 根据证件号查询卷烟零售商信息
    @Override
    public CigaretteRetailer getRetailerByCertificateNumber(String certificateNumber) {
        return cigaretteRetailerMapper.getRetailerByCertificateNumber(certificateNumber);
    }

    // 分页查询所有卷烟零售商信息，每页 15 条数据
    @Override
    public List<CigaretteRetailer> getAllRetailers(int page) {
        // 计算偏移量
        int offset = (page - 1) * 15;
        // 每页显示 15 条数据
        int limit = 15;
        return cigaretteRetailerMapper.getAllRetailers(offset, limit);
    }
}