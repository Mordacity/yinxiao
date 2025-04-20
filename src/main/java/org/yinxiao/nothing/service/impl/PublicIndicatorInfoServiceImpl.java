package org.yinxiao.nothing.service.impl;

/**
 * @Title: PublicIndicatorInfoServiceImpl
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.service.impl
 * @Date: 2025/4/20 16:39
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yinxiao.nothing.entity.PublicIndicatorInfo;
import org.yinxiao.nothing.mapper.PublicIndicatorInfoMapper;
import org.yinxiao.nothing.service.PublicIndicatorInfoService;

import java.util.List;

/**
 * 公共指标数据服务实现类，实现公共指标数据服务接口的方法
 */
@Service
public class PublicIndicatorInfoServiceImpl implements PublicIndicatorInfoService {

    @Autowired
    private PublicIndicatorInfoMapper publicIndicatorInfoMapper;

    @Override
    public int batchInsert(List<PublicIndicatorInfo> publicIndicatorInfos) {
        return publicIndicatorInfoMapper.batchInsert(publicIndicatorInfos);
    }

    @Override
    public int deleteByCertificateNumberAndId(String certificateNumber, Integer id) {
        return publicIndicatorInfoMapper.deleteByCertificateNumberAndId(certificateNumber, id);
    }

    @Override
    public int updateByCertificateNumberAndId(PublicIndicatorInfo publicIndicatorInfo) {
        return publicIndicatorInfoMapper.updateByCertificateNumberAndId(publicIndicatorInfo);
    }

    @Override
    public List<PublicIndicatorInfo> getByCertificateNumber(String certificateNumber) {
        return publicIndicatorInfoMapper.getByCertificateNumber(certificateNumber);
    }

    @Override
    public List<PublicIndicatorInfo> getAll(int page) {
        int offset = (page - 1) * 15;
        return publicIndicatorInfoMapper.getAll(offset, 15);
    }
}