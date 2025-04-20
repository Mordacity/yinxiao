package org.yinxiao.nothing.controller;

/**
 * @Title: CollegeRetailerController
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.controller
 * @Date: 2025/4/20 16:39
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yinxiao.nothing.common.Result;
import org.yinxiao.nothing.entity.CollegeRetailer;
import org.yinxiao.nothing.service.CollegeRetailerService;

import java.util.List;

// 高校零售户控制器类，处理与高校零售户相关的请求
@RestController
@RequestMapping("/college-retailers")
@Api(tags = "高校零售户管理接口")
public class CollegeRetailerController {

    // 注入 CollegeRetailerService 实例
    @Autowired
    private CollegeRetailerService collegeRetailerService;

    // 批量添加高校零售户信息
    @PostMapping("/batch-add")
    @ApiOperation("批量添加高校零售户信息")
    public Result<String> batchAddCollegeRetailers(@RequestBody List<CollegeRetailer> retailers) {
        // 遍历零售商列表，检查每个零售商的信息是否为空
        for (CollegeRetailer retailer : retailers) {
            if (retailer.getCertificateNumber() == null) {
                return Result.fail(506, "证件号数据未传递");
            }
            if (retailer.getCertificateNumber().isEmpty()) {
                return Result.fail(505, "证件号为空值");
            }
            if (retailer.getUniversityName() != null && retailer.getUniversityName().isEmpty()) {
                return Result.fail(505, "高校名称为空值");
            }
        }
        // 调用服务层的批量插入方法
        int result = collegeRetailerService.batchAddCollegeRetailers(retailers);
        if (result > 0) {
            return Result.success("高校零售户信息批量添加成功");
        } else {
            return Result.fail(501, "高校零售户信息批量添加失败");
        }
    }

    // 根据证件号删除高校零售户信息
    @DeleteMapping("/delete/{certificateNumber}")
    @ApiOperation("根据证件号删除高校零售户信息")
    public Result<String> deleteCollegeRetailerByCertificateNumber(@PathVariable String certificateNumber) {
        // 检查证件号是否为空
        if (certificateNumber == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (certificateNumber.isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        // 调用服务层的删除方法
        int result = collegeRetailerService.deleteCollegeRetailerByCertificateNumber(certificateNumber);
        if (result > 0) {
            return Result.success("高校零售户信息删除成功");
        } else {
            return Result.fail(502, "高校零售户信息删除失败");
        }
    }

    // 根据证件号修改高校零售户信息
    @PostMapping("/update")
    @ApiOperation("根据证件号修改高校零售户信息")
    public Result<String> updateCollegeRetailerByCertificateNumber(@RequestBody CollegeRetailer retailer) {
        // 检查证件号是否为空
        if (retailer.getCertificateNumber() == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (retailer.getCertificateNumber().isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        if (retailer.getUniversityName() != null && retailer.getUniversityName().isEmpty()) {
            return Result.fail(505, "高校名称为空值");
        }
        // 调用服务层的修改方法
        int result = collegeRetailerService.updateCollegeRetailerByCertificateNumber(retailer);
        if (result > 0) {
            return Result.success("高校零售户信息修改成功");
        } else {
            return Result.fail(503, "高校零售户信息修改失败");
        }
    }

    // 根据证件号查询高校零售户信息
    @GetMapping("/get")
    @ApiOperation("根据证件号查询高校零售户信息")
    public Result<CollegeRetailer> getCollegeRetailerByCertificateNumber(@RequestParam String certificateNumber) {
        // 检查证件号是否为空
        if (certificateNumber == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (certificateNumber.isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        // 调用服务层的查询方法
        CollegeRetailer retailer = collegeRetailerService.getCollegeRetailerByCertificateNumber(certificateNumber);
        if (retailer != null) {
            return Result.success(retailer);
        } else {
            return Result.fail(507, "未找到该高校零售户信息");
        }
    }

    // 分页查询所有高校零售户信息，每页 15 条数据
    @GetMapping("/get-all")
    @ApiOperation("分页查询所有高校零售户信息，每页 15 条数据")
    public Result<List<CollegeRetailer>> getAllCollegeRetailers(@RequestParam int page) {
        // 调用服务层的分页查询方法
        List<CollegeRetailer> retailers = collegeRetailerService.getAllCollegeRetailers(page);
        return Result.success(retailers);
    }
}