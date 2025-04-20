package org.yinxiao.nothing.service.impl;

/**
 * @Title: CommunityRetailerServiceImpl
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.service.impl
 * @Date: 2025/4/20 16:39
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yinxiao.nothing.entity.CommunityRetailer;
import org.yinxiao.nothing.mapper.CommunityRetailerMapper;
import org.yinxiao.nothing.service.CommunityRetailerService;

import java.util.List;

/**
 * 社区零售户服务实现类，实现社区零售户服务接口的方法
 */
@Service
public class CommunityRetailerServiceImpl implements CommunityRetailerService {

    @Autowired
    private CommunityRetailerMapper communityRetailerMapper;

    @Override
    public int addCommunityRetailers(List<CommunityRetailer> communityRetailers) {
        return communityRetailerMapper.addCommunityRetailers(communityRetailers);
    }

    @Override
    public int deleteCommunityRetailer(String certificateNumber) {
        return communityRetailerMapper.deleteCommunityRetailer(certificateNumber);
    }

    @Override
    public int updateCommunityRetailer(CommunityRetailer communityRetailer) {
        return communityRetailerMapper.updateCommunityRetailer(communityRetailer);
    }

    @Override
    public CommunityRetailer getCommunityRetailerByCertificateNumber(String certificateNumber) {
        return communityRetailerMapper.getCommunityRetailerByCertificateNumber(certificateNumber);
    }

    @Override
    public List<CommunityRetailer> getAllCommunityRetailers(int page) {
        int offset = (page - 1) * 15;
        return communityRetailerMapper.getAllCommunityRetailers(offset, 15);
    }
}