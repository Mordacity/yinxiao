package org.yinxiao.nothing.controller;
/**
 * @Title: CollegeTideFactorIndicatorController
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.controller
 * @Date: 2025/4/20 16:39
 */
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yinxiao.nothing.common.Result;
import org.yinxiao.nothing.entity.CollegeTideFactorIndicator;
import org.yinxiao.nothing.service.CollegeTideFactorIndicatorService;

import java.util.List;

/**
 * 高校潮汐因子指标控制器类，处理相关接口
 */
@RestController
@RequestMapping("/college-tide-factor-indicator")
@Api(tags = "高校潮汐因子指标管理接口")
public class CollegeTideFactorIndicatorController {

    @Autowired
    private CollegeTideFactorIndicatorService collegeTideFactorIndicatorService;

    /**
     * 批量插入高校潮汐因子指标数据
     * @param indicators 高校潮汐因子指标列表
     * @return 插入结果
     */
    @PostMapping("/batch-insert")
    @ApiOperation("批量插入高校潮汐因子指标数据")
    public Result<String> batchInsert(@RequestBody List<CollegeTideFactorIndicator> indicators) {
        for (CollegeTideFactorIndicator indicator : indicators) {
            if (indicator.getCertificateNumber() == null) {
                return Result.fail(506, "证件号数据未传递");
            }
            if (indicator.getCertificateNumber().isEmpty()) {
                return Result.fail(505, "证件号为空值");
            }
            // 可以添加更多字段的空值和未传递检查
        }
        int result = collegeTideFactorIndicatorService.batchInsert(indicators);
        if (result > 0) {
            return Result.success("高校潮汐因子指标数据批量插入成功");
        } else {
            return Result.fail(501, "高校潮汐因子指标数据批量插入失败");
        }
    }

    /**
     * 根据证件号删除高校潮汐因子指标数据
     * @param certificateNumber 证件号
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    @ApiOperation("根据证件号和ID删除高校潮汐因子指标数据")
    public Result<String> deleteByCertificateNumber(@RequestParam String certificateNumber, @RequestParam Integer id) {
        if (certificateNumber == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (certificateNumber.isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        if (id == null) {
            return Result.fail(506, "ID数据未传递");
        }
        int result = collegeTideFactorIndicatorService.deleteByCertificateNumber(certificateNumber,id);
        if (result > 0) {
            return Result.success("高校潮汐因子指标数据删除成功");
        } else {
            return Result.fail(502, "高校潮汐因子指标数据删除失败");
        }
    }

    /**
     * 根据证件号修改高校潮汐因子指标数据
     * @param indicator 高校潮汐因子指标对象
     * @return 修改结果
     */
    @PostMapping("/update")
    @ApiOperation("根据证件号和ID修改高校潮汐因子指标数据")
    public Result<String> updateByCertificateNumber(@RequestBody CollegeTideFactorIndicator indicator) {
        if (indicator.getCertificateNumber() == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (indicator.getCertificateNumber().isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        if (indicator.getId() == null) {
            return Result.fail(508, "ID数据未传递");
        }
        // 其他字段的校验可以根据需要添加
        int result = collegeTideFactorIndicatorService.updateByCertificateNumber(indicator);
        if (result > 0) {
            return Result.success("高校潮汐因子指标数据修改成功");
        } else {
            return Result.fail(503, "高校潮汐因子指标数据修改失败");
        }
    }


    /**
     * 根据证件号查询高校潮汐因子指标数据
     * @param certificateNumber 证件号
     * @return 查询结果
     */
    @GetMapping("/get")
    @ApiOperation("根据证件号查询高校潮汐因子指标数据")
    public Result<List<CollegeTideFactorIndicator>> getByCertificateNumber(@RequestParam String certificateNumber) {
        if (certificateNumber == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (certificateNumber.isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        List<CollegeTideFactorIndicator> indicators = collegeTideFactorIndicatorService.getByCertificateNumber(certificateNumber);
        return Result.success(indicators);
    }

    /**
     * 分页查询所有高校潮汐因子指标数据
     * @param page 页码
     * @return 查询结果
     */
    @GetMapping("/get-all")
    @ApiOperation("分页查询所有高校潮汐因子指标数据")
    public Result<List<CollegeTideFactorIndicator>> getAll(@RequestParam int page) {
        List<CollegeTideFactorIndicator> indicators = collegeTideFactorIndicatorService.getAll(page);
        return Result.success(indicators);
    }
}