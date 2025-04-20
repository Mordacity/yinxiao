package org.yinxiao.nothing.service;

/**
 * @Title: CommunityRetailerService
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.service
 * @Date: 2025/4/20 16:39
 */

import org.yinxiao.nothing.entity.CommunityRetailer;

import java.util.List;

/**
 * 社区零售户服务接口，定义社区零售户相关的业务逻辑方法
 */
public interface CommunityRetailerService {
    /**
     * 批量添加社区零售户信息
     * @param communityRetailers 社区零售户列表
     * @return 受影响的行数
     */
    int addCommunityRetailers(List<CommunityRetailer> communityRetailers);

    /**
     * 根据证件号删除社区零售户信息
     * @param certificateNumber 证件号
     * @return 受影响的行数
     */
    int deleteCommunityRetailer(String certificateNumber);

    /**
     * 根据证件号修改社区零售户信息
     * @param communityRetailer 社区零售户信息
     * @return 受影响的行数
     */
    int updateCommunityRetailer(CommunityRetailer communityRetailer);

    /**
     * 根据证件号查询社区零售户信息
     * @param certificateNumber 证件号
     * @return 社区零售户信息
     */
    CommunityRetailer getCommunityRetailerByCertificateNumber(String certificateNumber);

    /**
     * 分页查询所有社区零售户信息
     * @param page 页码
     * @return 社区零售户列表
     */
    List<CommunityRetailer> getAllCommunityRetailers(int page);
}