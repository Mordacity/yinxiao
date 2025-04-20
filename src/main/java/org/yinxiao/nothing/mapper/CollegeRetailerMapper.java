package org.yinxiao.nothing.mapper;

/**
 * @Title: CollegeRetailerMapper
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.mapper
 * @Date: 2025/4/20 16:39
 */

import org.apache.ibatis.annotations.Mapper;
import org.yinxiao.nothing.entity.CollegeRetailer;

import java.util.List;

// MyBatis Mapper 接口，定义与数据库交互的方法
@Mapper
public interface CollegeRetailerMapper {
    // 批量插入高校零售户信息
    int batchAddCollegeRetailers(List<CollegeRetailer> retailers);
    // 根据证件号删除高校零售户信息
    int deleteCollegeRetailerByCertificateNumber(String certificateNumber);
    // 根据证件号修改高校零售户信息
    int updateCollegeRetailerByCertificateNumber(CollegeRetailer retailer);
    // 根据证件号查询高校零售户信息
    CollegeRetailer getCollegeRetailerByCertificateNumber(String certificateNumber);
    // 分页查询所有高校零售户信息，每页 15 条数据
    List<CollegeRetailer> getAllCollegeRetailers(int offset, int limit);
}