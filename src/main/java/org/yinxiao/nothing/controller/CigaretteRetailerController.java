package org.yinxiao.nothing.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yinxiao.nothing.common.Result;
import org.yinxiao.nothing.entity.CigaretteRetailer;
import org.yinxiao.nothing.service.CigaretteRetailerService;

import java.util.List;

@RestController
@RequestMapping("/cigarette-retailers")
@Api(tags = "卷烟零售户管理接口")
public class CigaretteRetailerController {

    @Autowired
    private CigaretteRetailerService cigaretteRetailerService;

    /**
     * 添加卷烟零售户信息
     * @param retailer 卷烟零售户信息
     * @return 添加结果
     */
    @PostMapping("/add")
    @ApiOperation("添加卷烟零售户信息")
    public Result<String> addRetailer(@RequestBody CigaretteRetailer retailer) {
        int result = cigaretteRetailerService.addRetailer(retailer);
        if (result > 0) {
            return Result.success("卷烟零售户信息添加成功");
        } else {
            return Result.fail(501,"卷烟零售户信息添加失败");
        }
    }

    /**
     * 删除卷烟零售户信息
     * @param uuid 卷烟零售户 UUID
     * @return 删除结果
     */
    @DeleteMapping("/delete/{uuid}")
    @ApiOperation("删除卷烟零售户信息")
    public Result<String> deleteRetailer(@PathVariable String uuid) {
        int result = cigaretteRetailerService.deleteRetailer(uuid);
        if (result > 0) {
            return Result.success("卷烟零售户信息删除成功");
        } else {
            return Result.fail(502,"卷烟零售户信息删除失败");
        }
    }

    /**
     * 修改卷烟零售户信息
     * @param retailer 卷烟零售户信息
     * @return 修改结果
     */
    @PostMapping("/update")
    @ApiOperation("修改卷烟零售户信息")
    public Result<String> updateRetailer(@RequestBody CigaretteRetailer retailer) {
        int result = cigaretteRetailerService.updateRetailer(retailer);
        if (result > 0) {
            return Result.success("卷烟零售户信息修改成功");
        } else {
            return Result.fail(503,"卷烟零售户信息修改失败");
        }
    }

    /**
     * 根据 UUID 查询卷烟零售户信息
     * @param uuid 卷烟零售户 UUID
     * @return 卷烟零售户信息
     */
    @GetMapping("/get")
    @ApiOperation("根据 UUID 查询卷烟零售户信息")
    public Result<CigaretteRetailer> getRetailer(@RequestParam String uuid) {
        CigaretteRetailer retailer = cigaretteRetailerService.getRetailerByUuid(uuid);
        if (retailer != null) {
            return Result.success(retailer);
        } else {
            return Result.fail(507,"未找到该卷烟零售户信息");
        }
    }

    /**
     * 查询所有卷烟零售户信息
     * @return 所有卷烟零售户信息
     */
    @GetMapping("/get-all")
    @ApiOperation("查询所有卷烟零售户信息")
    public Result<List<CigaretteRetailer>> getAllRetailers() {
        List<CigaretteRetailer> retailers = cigaretteRetailerService.getAllRetailers();
        return Result.success(retailers);
    }
}