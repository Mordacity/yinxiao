package org.yinxiao.nothing.service;

/**
 * @Title: UserService
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.service
 * @Date: 2025/4/20 16:39
 */

import org.yinxiao.nothing.entity.User;

import java.util.List;

/**
 * 用户服务接口，定义用户相关的业务逻辑方法
 */
public interface UserService {
    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    User login(String username, String password);

    /**
     * 添加用户
     * @param user 用户对象
     * @return 受影响的行数
     */
    int addUser(User user);

    /**
     * 删除用户
     * @param id 用户 ID
     * @return 受影响的行数
     */
    int deleteUser(Integer id);

    /**
     * 修改用户信息
     * @param user 用户对象
     * @return 受影响的行数
     */
    int updateUser(User user);

    /**
     * 根据用户 ID 查询用户
     * @param id 用户 ID
     * @return 用户对象
     */
    User getUserById(Integer id);

    /**
     * 查询所有用户
     * @return 用户列表
     */
    List<User> getAllUsers();
}    