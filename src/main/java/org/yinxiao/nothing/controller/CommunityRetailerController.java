package org.yinxiao.nothing.controller;

/**
 * @Title: CommunityRetailerController
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.controller
 * @Date: 2025/4/20 16:39
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yinxiao.nothing.common.Result;
import org.yinxiao.nothing.entity.CommunityRetailer;
import org.yinxiao.nothing.service.CommunityRetailerService;

import java.util.List;

/**
 * 社区零售户控制器类，处理社区零售户相关接口
 */
@RestController
@RequestMapping("/community-retailers")
@Api(tags = "社区零售户管理接口")
public class CommunityRetailerController {

    @Autowired
    private CommunityRetailerService communityRetailerService;

    /**
     * 批量添加社区零售户信息
     * @param communityRetailers 社区零售户列表
     * @return 添加结果
     */
    @PostMapping("/add-batch")
    @ApiOperation("批量添加社区零售户信息")
    public Result<String> addCommunityRetailers(@RequestBody List<CommunityRetailer> communityRetailers) {
        for (CommunityRetailer retailer : communityRetailers) {
            if (retailer.getCertificateNumber() == null) {
                return Result.fail(506, "证件号数据未传递");
            }
            if (retailer.getCertificateNumber().isEmpty()) {
                return Result.fail(505, "证件号为空值");
            }
            if (retailer.getCommunityName() == null) {
                return Result.fail(506, "社区名称数据未传递");
            }
            if (retailer.getCommunityName().isEmpty()) {
                return Result.fail(505, "社区名称为空值");
            }
        }
        int result = communityRetailerService.addCommunityRetailers(communityRetailers);
        if (result > 0) {
            return Result.success("社区零售户信息添加成功");
        } else {
            return Result.fail(501, "社区零售户信息添加失败");
        }
    }

    /**
     * 根据证件号删除社区零售户信息
     * @param certificateNumber 证件号
     * @return 删除结果
     */
    @DeleteMapping("/delete/{certificateNumber}")
    @ApiOperation("根据证件号删除社区零售户信息")
    public Result<String> deleteCommunityRetailer(@PathVariable String certificateNumber) {
        if (certificateNumber == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (certificateNumber.isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        int result = communityRetailerService.deleteCommunityRetailer(certificateNumber);
        if (result > 0) {
            return Result.success("社区零售户信息删除成功");
        } else {
            return Result.fail(502, "社区零售户信息删除失败");
        }
    }

    /**
     * 根据证件号修改社区零售户信息
     * @param communityRetailer 社区零售户信息
     * @return 修改结果
     */
    @PostMapping("/update")
    @ApiOperation("根据证件号修改社区零售户信息")
    public Result<String> updateCommunityRetailer(@RequestBody CommunityRetailer communityRetailer) {
        if (communityRetailer.getCertificateNumber() == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (communityRetailer.getCertificateNumber().isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        if (communityRetailer.getCommunityName() == null) {
            return Result.fail(506, "社区名称数据未传递");
        }
        if (communityRetailer.getCommunityName().isEmpty()) {
            return Result.fail(505, "社区名称为空值");
        }
        if (communityRetailer.getId() == null) {
            return Result.fail(505, "ID数据为空值");
        }
        int result = communityRetailerService.updateCommunityRetailer(communityRetailer);
        if (result > 0) {
            return Result.success("社区零售户信息修改成功");
        } else {
            return Result.fail(503, "社区零售户信息修改失败");
        }
    }

    /**
     * 根据证件号查询社区零售户信息
     * @param certificateNumber 证件号
     * @return 社区零售户信息
     */
    @GetMapping("/get")
    @ApiOperation("根据证件号查询社区零售户信息")
    public Result<CommunityRetailer> getCommunityRetailer(@RequestParam String certificateNumber) {
        if (certificateNumber == null) {
            return Result.fail(506, "证件号数据未传递");
        }
        if (certificateNumber.isEmpty()) {
            return Result.fail(505, "证件号为空值");
        }
        CommunityRetailer retailer = communityRetailerService.getCommunityRetailerByCertificateNumber(certificateNumber);
        if (retailer != null) {
            return Result.success(retailer);
        } else {
            return Result.fail(507, "未找到该社区零售户信息");
        }
    }

    /**
     * 分页查询所有社区零售户信息
     * @param page 页码
     * @return 社区零售户列表
     */
    @GetMapping("/get-all")
    @ApiOperation("分页查询所有社区零售户信息")
    public Result<List<CommunityRetailer>> getAllCommunityRetailers(@RequestParam int page) {
        List<CommunityRetailer> retailers = communityRetailerService.getAllCommunityRetailers(page);
        return Result.success(retailers);
    }
}