package org.yinxiao.nothing.service.impl;

/**
 * @Title: CigaretteRetailerMapper
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.service.impl
 * @Date: 2025/4/20 16:39
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yinxiao.nothing.entity.CollegeTideFactorIndicator;
import org.yinxiao.nothing.mapper.CollegeTideFactorIndicatorMapper;
import org.yinxiao.nothing.service.CollegeTideFactorIndicatorService;

import java.util.List;

/**
 * 高校潮汐因子指标服务实现类
 */
@Service
public class CollegeTideFactorIndicatorServiceImpl implements CollegeTideFactorIndicatorService {

    @Autowired
    private CollegeTideFactorIndicatorMapper collegeTideFactorIndicatorMapper;

    @Override
    public int batchInsert(List<CollegeTideFactorIndicator> indicators) {
        return collegeTideFactorIndicatorMapper.batchInsert(indicators);
    }

    @Override
    public int deleteByCertificateNumber(String certificateNumber,Integer id) {
        return collegeTideFactorIndicatorMapper.deleteByCertificateNumber(certificateNumber,id);
    }

    @Override
    public int updateByCertificateNumber(CollegeTideFactorIndicator indicator) {
        return collegeTideFactorIndicatorMapper.updateByCertificateNumber(indicator);
    }

    @Override
    public List<CollegeTideFactorIndicator> getByCertificateNumber(String certificateNumber) {
        return collegeTideFactorIndicatorMapper.getByCertificateNumber(certificateNumber);
    }

    @Override
    public List<CollegeTideFactorIndicator> getAll(int page) {
        int offset = (page - 1) * 15;
        return collegeTideFactorIndicatorMapper.getAll(offset, 15);
    }
}