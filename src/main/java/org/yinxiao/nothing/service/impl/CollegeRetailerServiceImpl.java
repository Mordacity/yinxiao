package org.yinxiao.nothing.service.impl;

/**
 * @Title: CigaretteRetailerMapper
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.service.impl
 * @Date: 2025/4/20 16:39
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yinxiao.nothing.entity.CollegeRetailer;
import org.yinxiao.nothing.mapper.CollegeRetailerMapper;
import org.yinxiao.nothing.service.CollegeRetailerService;

import java.util.List;

// 高校零售户服务实现类，实现业务逻辑方法
@Service
public class CollegeRetailerServiceImpl implements CollegeRetailerService {

    // 注入 CollegeRetailerMapper 实例
    @Autowired
    private CollegeRetailerMapper collegeRetailerMapper;

    // 批量插入高校零售户信息
    @Override
    public int batchAddCollegeRetailers(List<CollegeRetailer> retailers) {
        return collegeRetailerMapper.batchAddCollegeRetailers(retailers);
    }

    // 根据证件号删除高校零售户信息
    @Override
    public int deleteCollegeRetailerByCertificateNumber(String certificateNumber) {
        return collegeRetailerMapper.deleteCollegeRetailerByCertificateNumber(certificateNumber);
    }

    // 根据证件号修改高校零售户信息
    @Override
    public int updateCollegeRetailerByCertificateNumber(CollegeRetailer retailer) {
        return collegeRetailerMapper.updateCollegeRetailerByCertificateNumber(retailer);
    }

    // 根据证件号查询高校零售户信息
    @Override
    public CollegeRetailer getCollegeRetailerByCertificateNumber(String certificateNumber) {
        return collegeRetailerMapper.getCollegeRetailerByCertificateNumber(certificateNumber);
    }

    // 分页查询所有高校零售户信息，每页 15 条数据
    @Override
    public List<CollegeRetailer> getAllCollegeRetailers(int page) {
        // 计算偏移量
        int offset = (page - 1) * 15;
        // 每页显示 15 条数据
        int limit = 15;
        return collegeRetailerMapper.getAllCollegeRetailers(offset, limit);
    }
}