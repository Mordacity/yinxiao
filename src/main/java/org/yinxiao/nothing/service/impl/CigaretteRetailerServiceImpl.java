package org.yinxiao.nothing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yinxiao.nothing.entity.CigaretteRetailer;
import org.yinxiao.nothing.mapper.CigaretteRetailerMapper;
import org.yinxiao.nothing.service.CigaretteRetailerService;

import java.util.List;

@Service
public class CigaretteRetailerServiceImpl implements CigaretteRetailerService {

    @Autowired
    private CigaretteRetailerMapper cigaretteRetailerMapper;

    @Override
    public int addRetailer(CigaretteRetailer retailer) {
        return cigaretteRetailerMapper.addRetailer(retailer);
    }

    @Override
    public int deleteRetailer(String uuid) {
        return cigaretteRetailerMapper.deleteRetailer(uuid);
    }

    @Override
    public int updateRetailer(CigaretteRetailer retailer) {
        return cigaretteRetailerMapper.updateRetailer(retailer);
    }

    @Override
    public CigaretteRetailer getRetailerByUuid(String uuid) {
        return cigaretteRetailerMapper.getRetailerByUuid(uuid);
    }

    @Override
    public List<CigaretteRetailer> getAllRetailers() {
        return cigaretteRetailerMapper.getAllRetailers();
    }
}