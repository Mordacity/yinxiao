package org.yinxiao.nothing.common;

/**
 * @Title: Result
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.common
 * @Date: 2025/4/20 16:39
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用返回结果类
 * @param <T> 数据类型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    /**
     * 成功返回结果
     * @param data 数据
     * @param <T> 数据类型
     * @return 结果对象
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }

    /**
     * 失败返回结果
     * @param message 错误信息
     * @param <T> 数据类型
     * @return 结果对象
     */
    public static <T> Result<T> fail(Integer code,String message) {
        return new Result<>(code, message, null);
    }
    /**
     * 501 插入失败
     * 502 删除失败
     * 503 更新失败
     * 504 登录失败
     * 505 未传递正确参数
     * 506 未传递参数
     * 507 查询失败
     * 508 未登录
     * 509 数据已存在
     */
}    