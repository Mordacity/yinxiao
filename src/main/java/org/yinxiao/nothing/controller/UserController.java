package org.yinxiao.nothing.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.yinxiao.nothing.common.Result;
import org.yinxiao.nothing.entity.User;
import org.yinxiao.nothing.entity.UserDTO;
import org.yinxiao.nothing.service.UserService;
import org.yinxiao.nothing.utils.JwtUtil;
import org.yinxiao.nothing.utils.TokenBlacklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户控制器类，处理用户相关接口
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理接口")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private TokenBlacklist tokenBlacklist;

    /**
     * 用户登录接口
     * @param username 用户名
     * @param password 密码
     * @return 登录结果
     */
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result<Map<String, Object>> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.login(username, password);
        if (user != null) {
            String token = jwtUtil.generateToken(user.getId());
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("token", token);
            resultMap.put("user", user);
            return Result.success(resultMap);
        } else {
            return Result.fail(508,"用户名或密码错误");
        }
    }

    /**
     * 添加用户接口
     * @param username 用户名
     * @param password 密码
     * @return 添加结果
     */
    @PostMapping("/add")
    @ApiOperation("添加用户")
    public Result<String> addUser(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        int result = userService.addUser(user);
        if (result > 0) {
            return Result.success("用户添加成功");
        } else {
            return Result.fail(501,"用户添加失败");
        }
    }

    /**
     * 删除用户接口
     * @param id 用户 ID
     * @return 删除结果
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除用户")
    public Result<String> deleteUser(@PathVariable Integer id) {
        int result = userService.deleteUser(id);
        if (result > 0) {
            return Result.success("用户删除成功");
        } else {
            return Result.fail(502,"用户删除失败");
        }
    }

    /**
     * 修改用户接口
     * @param id 用户 ID
     * @param username 用户名
     * @param password 密码
     * @return 修改结果
     */
    @PostMapping("/update")
    @ApiOperation("修改用户信息")
    public Result<String> updateUser(@RequestParam Integer id, @RequestParam String username, @RequestParam String password) {
        // 创建用户对象
        User user = new User();
        // 设置用户 ID
        user.setId(id);
        // 设置用户名
        user.setUsername(username);
        // 设置密码
        user.setPassword(password);
        // 调用用户服务修改用户信息
        int result = userService.updateUser(user);
        // 判断修改结果
        if (result > 0) {
            // 修改成功
            return Result.success("用户修改成功");
        } else {
            // 修改失败
            return Result.fail(503,"用户修改失败");
        }
    }

    /**
     * 查询用户接口，接收 id 参数
     * @param id 用户 ID
     * @return 用户信息
     */
    @GetMapping("/get")
    @ApiOperation("查询用户信息")
    public Result<UserDTO> getUser(@RequestParam Integer id) {
        User user = userService.getUserById(id);
        if (user != null) {
            UserDTO userDTO = UserDTO.fromUser(user);
            return Result.success(userDTO);
        } else {
            return Result.fail(507,"用户不存在");
        }
    }

    /**
     * 注销登录接口
     * @param token 用户 Token
     * @return 注销结果
     */
    @PostMapping("/logout")
    @ApiOperation("用户注销登录")
    public Result<String> logout(@RequestHeader("Authorization") String token) {
        // 从 Token 中获取过期时间
        long expiration = jwtUtil.getExpirationFromToken(token) - System.currentTimeMillis();
        if (expiration > 0) {
            tokenBlacklist.addToBlacklist(token, expiration);
        }
        return Result.success("用户注销登录成功");
    }
}