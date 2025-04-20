package org.yinxiao.nothing.controller;

/**
 * @Title: CigaretteRetailerController
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.controller
 * @Date: 2025/4/20 16:39
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yinxiao.nothing.common.Result;
import org.yinxiao.nothing.entity.CigaretteRetailer;
import org.yinxiao.nothing.service.CigaretteRetailerService;

import java.util.List;

// 卷烟零售商控制器类，处理与卷烟零售商相关的请求
@RestController
@RequestMapping("/cigarette-retailers")
@Api(tags = "卷烟零售商管理接口")
public class CigaretteRetailerController {

    // 注入 CigaretteRetailerService 实例
    @Autowired
    private CigaretteRetailerService cigaretteRetailerService;

    // 批量添加卷烟零售商信息
    @PostMapping("/batch-add")
    @ApiOperation("批量添加卷烟零售商信息")
    public Result<String> batchAddRetailers(@RequestBody List<CigaretteRetailer> retailers) {
        // 遍历零售商列表，检查每个零售商的信息是否为空
        for (CigaretteRetailer retailer : retailers) {
            if (retailer.getCertificateNumber() == null) {
                return Result.fail(506, "证件号数据未传递");
            }
            if (retailer.getCertificateNumber().isEmpty()) {
                return Result.fail(505, "证件号为空值");
            }
            if (retailer.getShopName() != null && retailer.getShopName().isEmpty()) {
                return Result.fail(505, "店铺名称为空值");
            }
            if (retailer.getShopOwner() != null && retailer.getShopOwner().isEmpty()) {
                return Result.fail(505, "店铺负责人为空值");
            }
        }
        // 调用服务层的批量插入方法
        int result = cigaretteRetailerService.batchAddRetailers(retailers);
        if (result > 0) {
            return Result.success("卷烟零售商信息批量添加成功");
        } else {
            return Result.fail(501, "卷烟零售商信息批量添加失败");
        }
    }

    // 根据证件号删除卷烟零售商信息
    @DeleteMapping("/delete/{certificateNumber}")
    @ApiOperation("根据证件号删除卷烟零售商信息")
    public Result<String> deleteRetailerByCertificateNumber(@PathVariable String certificateNumber) {
        // 检查证件号是否为空
        if (certificateNumber == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (certificateNumber.isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        // 调用服务层的删除方法
        int result = cigaretteRetailerService.deleteRetailerByCertificateNumber(certificateNumber);
        if (result > 0) {
            return Result.success("卷烟零售商信息删除成功");
        } else {
            return Result.fail(502, "卷烟零售商信息删除失败");
        }
    }

    // 根据证件号修改卷烟零售商信息
    @PostMapping("/update")
    @ApiOperation("根据证件号修改卷烟零售商信息")
    public Result<String> updateRetailerByCertificateNumber(@RequestBody CigaretteRetailer retailer) {
        // 检查证件号是否为空
        if (retailer.getCertificateNumber() == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (retailer.getCertificateNumber().isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        if (retailer.getShopName() != null && retailer.getShopName().isEmpty()) {
            return Result.fail(505, "店铺名称为空值");
        }
        if (retailer.getShopOwner() != null && retailer.getShopOwner().isEmpty()) {
            return Result.fail(505, "店铺负责人为空值");
        }
        // 调用服务层的修改方法
        int result = cigaretteRetailerService.updateRetailerByCertificateNumber(retailer);
        if (result > 0) {
            return Result.success("卷烟零售商信息修改成功");
        } else {
            return Result.fail(503, "卷烟零售商信息修改失败");
        }
    }

    // 根据证件号查询卷烟零售商信息
    @GetMapping("/get")
    @ApiOperation("根据证件号查询卷烟零售商信息")
    public Result<CigaretteRetailer> getRetailerByCertificateNumber(@RequestParam String certificateNumber) {
        // 检查证件号是否为空
        if (certificateNumber == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (certificateNumber.isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        // 调用服务层的查询方法
        CigaretteRetailer retailer = cigaretteRetailerService.getRetailerByCertificateNumber(certificateNumber);
        if (retailer != null) {
            return Result.success(retailer);
        } else {
            return Result.fail(507, "未找到该卷烟零售商信息");
        }
    }

    // 分页查询所有卷烟零售商信息，每页 15 条数据
    @GetMapping("/get-all")
    @ApiOperation("分页查询所有卷烟零售商信息，每页 15 条数据")
    public Result<List<CigaretteRetailer>> getAllRetailers(@RequestParam int page) {
        // 调用服务层的分页查询方法
        List<CigaretteRetailer> retailers = cigaretteRetailerService.getAllRetailers(page);
        return Result.success(retailers);
    }
}