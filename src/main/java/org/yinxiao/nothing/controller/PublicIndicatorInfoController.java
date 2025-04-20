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
     * 批量添加公共指标数据信息
     * @param publicIndicatorInfos 公共指标数据列表
     * @return 添加结果
     */
    @PostMapping("/add-batch")
    @ApiOperation("批量添加公共指标数据信息")
    public Result<String> addPublicIndicatorInfos(@RequestBody List<PublicIndicatorInfo> publicIndicatorInfos) {
        for (PublicIndicatorInfo info : publicIndicatorInfos) {
            if (info.getCertificateNumber() == null) {
                return Result.fail(506, "证件号数据未传递");
            }
            if (info.getCertificateNumber().isEmpty()) {
                return Result.fail(505, "证件号为空值");
            }
            // 其他字段的校验可以根据需要添加
        }
        int result = publicIndicatorInfoService.addPublicIndicatorInfos(publicIndicatorInfos);
        if (result > 0) {
            return Result.success("公共指标数据信息添加成功");
        } else {
            return Result.fail(501, "公共指标数据信息添加失败");
        }
    }

    /**
     * 根据证件号删除公共指标数据信息
     * @param certificateNumber 证件号
     * @return 删除结果
     */
    @DeleteMapping("/delete/{certificateNumber}")
    @ApiOperation("根据证件号删除公共指标数据信息")
    public Result<String> deletePublicIndicatorInfo(@PathVariable String certificateNumber) {
        if (certificateNumber == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (certificateNumber.isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        int result = publicIndicatorInfoService.deletePublicIndicatorInfo(certificateNumber);
        if (result > 0) {
            return Result.success("公共指标数据信息删除成功");
        } else {
            return Result.fail(502, "公共指标数据信息删除失败");
        }
    }

    /**
     * 根据证件号修改公共指标数据信息
     * @param publicIndicatorInfo 公共指标数据信息
     * @return 修改结果
     */
    @PostMapping("/update")
    @ApiOperation("根据证件号修改公共指标数据信息")
    public Result<String> updatePublicIndicatorInfo(@RequestBody PublicIndicatorInfo publicIndicatorInfo) {
        if (publicIndicatorInfo.getCertificateNumber() == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (publicIndicatorInfo.getCertificateNumber().isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        // 其他字段的校验可以根据需要添加
        int result = publicIndicatorInfoService.updatePublicIndicatorInfo(publicIndicatorInfo);
        if (result > 0) {
            return Result.success("公共指标数据信息修改成功");
        } else {
            return Result.fail(503, "公共指标数据信息修改失败");
        }
    }

    /**
     * 根据证件号查询公共指标数据信息
     * @param certificateNumber 证件号
     * @return 公共指标数据信息列表
     */
    @GetMapping("/get")
    @ApiOperation("根据证件号查询公共指标数据信息")
    public Result<List<PublicIndicatorInfo>> getPublicIndicatorInfo(@RequestParam String certificateNumber) {
        if (certificateNumber == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (certificateNumber.isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        List<PublicIndicatorInfo> infos = publicIndicatorInfoService.getPublicIndicatorInfoByCertificateNumber(certificateNumber);
        if (!infos.isEmpty()) {
            return Result.success(infos);
        } else {
            return Result.fail(507, "未找到该证件号对应的公共指标数据信息");
        }
    }

    /**
     * 分页查询所有公共指标数据信息
     * @param page 页码
     * @return 公共指标数据信息列表
     */
    @GetMapping("/get-all")
    @ApiOperation("分页查询所有公共指标数据信息")
    public Result<List<PublicIndicatorInfo>> getAllPublicIndicatorInfos(@RequestParam int page) {
        List<PublicIndicatorInfo> infos = publicIndicatorInfoService.getAllPublicIndicatorInfos(page);
        return Result.success(infos);
    }
}
