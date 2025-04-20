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
    public int addPublicIndicatorInfos(List<PublicIndicatorInfo> publicIndicatorInfos) {
        return publicIndicatorInfoMapper.addPublicIndicatorInfos(publicIndicatorInfos);
    }

    @Override
    public int deletePublicIndicatorInfo(String certificateNumber) {
        return publicIndicatorInfoMapper.deletePublicIndicatorInfo(certificateNumber);
    }

    @Override
    public int updatePublicIndicatorInfo(PublicIndicatorInfo publicIndicatorInfo) {
        return publicIndicatorInfoMapper.updatePublicIndicatorInfo(publicIndicatorInfo);
    }

    @Override
    public List<PublicIndicatorInfo> getPublicIndicatorInfoByCertificateNumber(String certificateNumber) {
        return publicIndicatorInfoMapper.getPublicIndicatorInfoByCertificateNumber(certificateNumber);
    }

    @Override
    public List<PublicIndicatorInfo> getAllPublicIndicatorInfos(int page) {
        int offset = (page - 1) * 15;
        return publicIndicatorInfoMapper.getAllPublicIndicatorInfos(offset, 15);
    }
}