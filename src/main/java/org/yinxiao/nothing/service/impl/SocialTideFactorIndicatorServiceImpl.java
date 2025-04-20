package org.yinxiao.nothing.service.impl;

/**
 * @Title: SocialTideFactorIndicatorServiceImpl
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.service.impl
 * @Date: 2025/4/20 17:11
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yinxiao.nothing.entity.SocialTideFactorIndicator;
import org.yinxiao.nothing.mapper.SocialTideFactorIndicatorMapper;
import org.yinxiao.nothing.service.SocialTideFactorIndicatorService;

import java.util.List;

/**
 * 社会潮汐因子指标服务实现类，实现相关的业务逻辑方法
 */
@Service
public class SocialTideFactorIndicatorServiceImpl implements SocialTideFactorIndicatorService {

    @Autowired
    private SocialTideFactorIndicatorMapper mapper;

    @Override
    public int batchInsert(List<SocialTideFactorIndicator> indicators) {
        return mapper.batchInsert(indicators);
    }

    @Override
    public int deleteByCertificateNumber(String certificateNumber,Integer id) {
        return mapper.deleteByCertificateNumber(certificateNumber,id);
    }

    @Override
    public int updateByCertificateNumber(SocialTideFactorIndicator indicator) {
        return mapper.updateByCertificateNumber(indicator);
    }

    @Override
    public List<SocialTideFactorIndicator> selectByCertificateNumber(String certificateNumber) {
        return mapper.selectByCertificateNumber(certificateNumber);
    }

    @Override
    public List<SocialTideFactorIndicator> selectAll(int page) {
        int offset = (page - 1) * 15;
        return mapper.selectAll(offset, 15);
    }
}
