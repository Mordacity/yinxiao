package org.yinxiao.nothing.controller;

/**
 * @Title: SocialTideFactorIndicatorController
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.controller
 * @Date: 2025/4/20 17:11
 */
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yinxiao.nothing.common.Result;
import org.yinxiao.nothing.entity.SocialTideFactorIndicator;
import org.yinxiao.nothing.service.SocialTideFactorIndicatorService;

import java.util.List;

/**
 * 社会潮汐因子指标控制器类，处理相关接口
 */
@RestController
@RequestMapping("/social-tide-factor-indicators")
@Api(tags = "社会潮汐因子指标管理接口")
public class SocialTideFactorIndicatorController {

    @Autowired
    private SocialTideFactorIndicatorService service;

    /**
     * 批量插入社会潮汐因子指标数据
     * @param indicators 社会潮汐因子指标列表
     * @return 插入结果
     */
    @PostMapping("/batch-insert")
    @ApiOperation("批量插入社会潮汐因子指标数据")
    public Result<String> batchInsert(@RequestBody List<SocialTideFactorIndicator> indicators) {
        for (SocialTideFactorIndicator indicator : indicators) {
            if (indicator.getCertificateNumber() == null) {
                return Result.fail(500, "证件号数据未传递");
            }
            if (indicator.getCommunityName() == null) {
                return Result.fail(500, "社区名称数据未传递");
            }
            if (indicator.getResidentPopulation() == null) {
                return Result.fail(500, "常住人口数量数据未传递");
            }
            if (indicator.getSmokingRate() == null) {
                return Result.fail(500, "吸烟率数据未传递");
            }
            if (indicator.getGeographicalWeight() == null) {
                return Result.fail(500, "地理权重数据未传递");
            }
        }
        int result = service.batchInsert(indicators);
        if (result > 0) {
            return Result.success("社会潮汐因子指标数据批量插入成功");
        } else {
            return Result.fail(501, "社会潮汐因子指标数据批量插入失败");
        }
    }

    /**
     * 根据证件号删除社会潮汐因子指标数据
     * @param certificateNumber 证件号
     * @return 删除结果
     */
    @DeleteMapping("/delete/{certificateNumber}")
    @ApiOperation("根据证件号删除社会潮汐因子指标数据")
    public Result<String> deleteByCertificateNumber(@PathVariable String certificateNumber) {
        if (certificateNumber == null || certificateNumber.isEmpty()) {
            return Result.fail(500, "证件号为空值");
        }
        int result = service.deleteByCertificateNumber(certificateNumber);
        if (result > 0) {
            return Result.success("社会潮汐因子指标数据删除成功");
        } else {
            return Result.fail(502, "社会潮汐因子指标数据删除失败");
        }
    }

    /**
     * 根据证件号修改社会潮汐因子指标数据
     * @param indicator 社会潮汐因子指标对象
     * @return 修改结果
     */
    @PostMapping("/update")
    @ApiOperation("根据证件号修改社会潮汐因子指标数据")
    public Result<String> updateByCertificateNumber(@RequestBody SocialTideFactorIndicator indicator) {
        if (indicator.getCertificateNumber() == null || indicator.getCertificateNumber().isEmpty()) {
            return Result.fail(500, "证件号为空值");
        }
        if (indicator.getCommunityName() == null) {
            return Result.fail(500, "社区名称数据未传递");
        }
        if (indicator.getResidentPopulation() == null) {
            return Result.fail(500, "常住人口数量数据未传递");
        }
        if (indicator.getSmokingRate() == null) {
            return Result.fail(500, "吸烟率数据未传递");
        }
        if (indicator.getGeographicalWeight() == null) {
            return Result.fail(500, "地理权重数据未传递");
        }
        int result = service.updateByCertificateNumber(indicator);
        if (result > 0) {
            return Result.success("社会潮汐因子指标数据修改成功");
        } else {
            return Result.fail(503, "社会潮汐因子指标数据修改失败");
        }
    }

    /**
     * 根据证件号查询社会潮汐因子指标数据
     * @param certificateNumber 证件号
     * @return 查询结果
     */
    @GetMapping("/get")
    @ApiOperation("根据证件号查询社会潮汐因子指标数据")
    public Result<List<SocialTideFactorIndicator>> selectByCertificateNumber(@RequestParam String certificateNumber) {
        if (certificateNumber == null || certificateNumber.isEmpty()) {
            return Result.fail(500, "证件号为空值");
        }
        List<SocialTideFactorIndicator> indicators = service.selectByCertificateNumber(certificateNumber);
        if (indicators != null && !indicators.isEmpty()) {
            return Result.success(indicators);
        } else {
            return Result.fail(507, "未找到该证件号对应的社会潮汐因子指标数据");
        }
    }

    /**
     * 查询所有社会潮汐因子指标数据，支持分页
     * @param page 页码
     * @return 查询结果
     */
    @GetMapping("/get-all")
    @ApiOperation("查询所有社会潮汐因子指标数据，支持分页")
    public Result<List<SocialTideFactorIndicator>> selectAll(@RequestParam int page) {
        List<SocialTideFactorIndicator> indicators = service.selectAll(page);
        return Result.success(indicators);
    }
}
