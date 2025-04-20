package org.yinxiao.nothing.controller;

/**
 * @Title: PublicIndicatorInfoController
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.controller
 * @Date: 2025/4/20 16:39
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yinxiao.nothing.common.Result;
import org.yinxiao.nothing.entity.PublicIndicatorInfo;
import org.yinxiao.nothing.service.PublicIndicatorInfoService;

import java.util.List;

/**
 * 公共指标数据控制器类，处理公共指标数据相关接口
 */
@RestController
@RequestMapping("/public-indicator-infos")
@Api(tags = "公共指标数据管理接口")
public class PublicIndicatorInfoController {

    @Autowired
    private PublicIndicatorInfoService publicIndicatorInfoService;

    /**
     * 批量插入公共指标数据接口
     * @param publicIndicatorInfos 公共指标数据列表
     * @return 插入结果
     */
    @PostMapping("/batch-insert")
    @ApiOperation("批量插入公共指标数据")
    public Result<String> batchInsert(@RequestBody List<PublicIndicatorInfo> publicIndicatorInfos) {
        // 检查前端返回值是否为空
        for (PublicIndicatorInfo info : publicIndicatorInfos) {
            if (info.getCertificateNumber() == null) {
                return Result.fail(506, "证件号数据未传递");
            }
            if (info.getCertificateNumber().isEmpty()) {
                return Result.fail(505, "证件号为空值");
            }
            // 可根据需要添加其他字段的检查
        }
        int result = publicIndicatorInfoService.batchInsert(publicIndicatorInfos);
        if (result > 0) {
            return Result.success("公共指标数据批量插入成功");
        } else {
            return Result.fail(501, "公共指标数据批量插入失败");
        }
    }

    /**
     * 根据证件号和 ID 删除公共指标数据接口
     * @param certificateNumber 证件号
     * @param id 自增 ID
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    @ApiOperation("根据证件号和 ID 删除公共指标数据")
    public Result<String> deleteByCertificateNumberAndId(@RequestParam String certificateNumber, @RequestParam Integer id) {
        // 检查前端返回值是否为空
        if (certificateNumber == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (certificateNumber.isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        if (id == null) {
            return Result.fail(506, "ID 数据未传递");
        }
        int result = publicIndicatorInfoService.deleteByCertificateNumberAndId(certificateNumber, id);
        if (result > 0) {
            return Result.success("公共指标数据删除成功");
        } else {
            return Result.fail(502, "公共指标数据删除失败");
        }
    }

    /**
     * 根据证件号和 ID 修改公共指标数据接口
     * @param publicIndicatorInfo 公共指标数据对象
     * @return 修改结果
     */
    @PostMapping("/update")
    @ApiOperation("根据证件号和 ID 修改公共指标数据")
    public Result<String> updateByCertificateNumberAndId(@RequestBody PublicIndicatorInfo publicIndicatorInfo) {
        // 检查前端返回值是否为空
        if (publicIndicatorInfo.getCertificateNumber() == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (publicIndicatorInfo.getCertificateNumber().isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        if (publicIndicatorInfo.getId() == null) {
            return Result.fail(506, "ID 数据未传递");
        }
        int result = publicIndicatorInfoService.updateByCertificateNumberAndId(publicIndicatorInfo);
        if (result > 0) {
            return Result.success("公共指标数据修改成功");
        } else {
            return Result.fail(503, "公共指标数据修改失败");
        }
    }

    /**
     * 根据证件号查询公共指标数据接口
     * @param certificateNumber 证件号
     * @return 公共指标数据列表
     */
    @GetMapping("/get-by-certificate-number")
    @ApiOperation("根据证件号查询公共指标数据")
    public Result<List<PublicIndicatorInfo>> getByCertificateNumber(@RequestParam String certificateNumber) {
        // 检查前端返回值是否为空
        if (certificateNumber == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (certificateNumber.isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        List<PublicIndicatorInfo> publicIndicatorInfos = publicIndicatorInfoService.getByCertificateNumber(certificateNumber);
        return Result.success(publicIndicatorInfos);
    }

    /**
     * 查询所有公共指标数据接口，分页查询
     * @param page 页码
     * @return 公共指标数据列表
     */
    @GetMapping("/get-all")
    @ApiOperation("查询所有公共指标数据，分页查询")
    public Result<List<PublicIndicatorInfo>> getAll(@RequestParam int page) {
        List<PublicIndicatorInfo> publicIndicatorInfos = publicIndicatorInfoService.getAll(page);
        return Result.success(publicIndicatorInfos);
    }
}