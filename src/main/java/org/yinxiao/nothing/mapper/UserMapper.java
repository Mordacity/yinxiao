package org.yinxiao.nothing.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.yinxiao.nothing.entity.User;

import java.util.List;

/**
 * 用户数据访问接口，定义用户相关的数据库操作方法
 */
@Mapper
public interface UserMapper {
    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    User findByUsernameAndPassword(String username, String password);

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