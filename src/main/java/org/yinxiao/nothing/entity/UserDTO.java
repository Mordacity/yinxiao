package org.yinxiao.nothing.entity;

/**
 * @Title: UserDTO
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.entity
 * @Date: 2025/4/20 16:39
 */

import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    private String username;

    // 从 User 对象转换为 UserDTO 对象
    public static UserDTO fromUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }
}