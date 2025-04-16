package org.yinxiao.nothing.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.yinxiao.nothing.common.Result;
import org.yinxiao.nothing.utils.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Token 拦截器，用于验证 Token 的有效性
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断请求的URI是否包含"/user/login"，如果是，则直接返回true
        if (request.getRequestURI().contains("/user/login")) {
            return true;
        }
        // 获取请求头中的Authorization字段
        String token = request.getHeader("Authorization");
        // 验证token是否有效
        if (!jwtUtil.validateToken(token)) {
            // 设置响应内容类型为JSON
            response.setContentType("application/json;charset=UTF-8");
            // 创建ObjectMapper对象
            ObjectMapper objectMapper = new ObjectMapper();
            // 将Result.fail("请登录")转换为JSON字符串
            String jsonResponse = objectMapper.writeValueAsString(Result.fail("请登录"));
            // 将JSON字符串写入响应
            response.getWriter().write(jsonResponse);
            // 返回false，表示请求未通过验证
            return false;
        }
        // 返回true，表示请求通过验证
        return true;
    }
}    