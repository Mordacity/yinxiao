package org.yinxiao.nothing.filter;

/**
 * @Title: XSSFilter
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.filter
 * @Date: 2025/4/20 17:18
 */
// 导入 Apache Commons Text 库中的 StringEscapeUtils 类，用于对 HTML 字符进行转义
import org.apache.commons.text.StringEscapeUtils;
// 导入 Spring 框架的 Component 注解，用于将该类标记为 Spring 组件，使其能被 Spring 容器管理
import org.springframework.stereotype.Component;
// 导入 Servlet 相关的基础类，用于处理 Servlet 请求和响应
import javax.servlet.*;
// 导入 HttpServletRequest 类，用于处理 HTTP 请求
import javax.servlet.http.HttpServletRequest;
// 导入 HttpServletRequestWrapper 类，用于对 HttpServletRequest 进行包装和扩展
import javax.servlet.http.HttpServletRequestWrapper;
// 导入 IOException 类，用于处理输入输出异常
import java.io.IOException;
// 导入 HashMap 类，用于存储键值对数据
import java.util.HashMap;
// 导入 Map 接口，用于定义键值对集合的操作
import java.util.Map;

// 使用 @Component 注解将该类标记为 Spring 组件
@Component
// 定义一个名为 XSSFilter 的类，实现 Filter 接口，用于过滤 XSS 攻击
public class XSSFilter implements Filter {

    // 实现 Filter 接口的 doFilter 方法，该方法是过滤器的核心方法，用于处理请求和响应
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 将请求对象转换为 HttpServletRequest 类型，并使用自定义的 XSSRequestWrapper 进行包装
        // 然后将包装后的请求传递给过滤器链的下一个过滤器或目标资源
        chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
    }

    // 定义一个私有的静态内部类 XSSRequestWrapper，继承自 HttpServletRequestWrapper
    // 用于对 HttpServletRequest 进行扩展，实现对请求参数的 XSS 过滤
    private static class XSSRequestWrapper extends HttpServletRequestWrapper {

        // 构造函数，接收一个 HttpServletRequest 对象作为参数
        // 调用父类的构造函数进行初始化
        public XSSRequestWrapper(HttpServletRequest request) {
            super(request);
        }

        // 重写 getParameterValues 方法，用于获取请求参数的多个值
        @Override
        public String[] getParameterValues(String parameter) {
            // 调用父类的 getParameterValues 方法获取原始的参数值数组
            String[] values = super.getParameterValues(parameter);
            // 如果原始参数值数组为空，则直接返回 null
            if (values == null) {
                return null;
            }
            // 获取原始参数值数组的长度
            int count = values.length;
            // 创建一个与原始参数值数组长度相同的新数组，用于存储转义后的参数值
            String[] encodedValues = new String[count];
            // 遍历原始参数值数组
            for (int i = 0; i < count; i++) {
                // 使用 StringEscapeUtils.escapeHtml4 方法对每个参数值进行 HTML 转义
                // 并将转义后的结果存储到新数组中
                encodedValues[i] = StringEscapeUtils.escapeHtml4(values[i]);
            }
            // 返回转义后的参数值数组
            return encodedValues;
        }

        // 重写 getParameter 方法，用于获取单个请求参数的值
        @Override
        public String getParameter(String parameter) {
            // 调用父类的 getParameter 方法获取原始的参数值
            String value = super.getParameter(parameter);
            // 如果原始参数值为空，则直接返回 null
            if (value == null) {
                return null;
            }
            // 使用 StringEscapeUtils.escapeHtml4 方法对参数值进行 HTML 转义，并返回转义后的结果
            return StringEscapeUtils.escapeHtml4(value);
        }

        // 重写 getParameterMap 方法，用于获取请求参数的键值对映射
        @Override
        public Map<String, String[]> getParameterMap() {
            // 调用父类的 getParameterMap 方法获取原始的参数键值对映射
            Map<String, String[]> map = super.getParameterMap();
            // 创建一个新的 HashMap 对象，用于存储转义后的参数键值对映射
            Map<String, String[]> encodedMap = new HashMap<>();
            // 遍历原始的参数键值对映射
            for (Map.Entry<String, String[]> entry : map.entrySet()) {
                // 获取当前键值对中的参数值数组
                String[] values = entry.getValue();
                // 如果参数值数组不为空
                if (values != null) {
                    // 获取参数值数组的长度
                    int count = values.length;
                    // 创建一个与参数值数组长度相同的新数组，用于存储转义后的参数值
                    String[] encodedValues = new String[count];
                    // 遍历参数值数组
                    for (int i = 0; i < count; i++) {
                        // 使用 StringEscapeUtils.escapeHtml4 方法对每个参数值进行 HTML 转义
                        // 并将转义后的结果存储到新数组中
                        encodedValues[i] = StringEscapeUtils.escapeHtml4(values[i]);
                    }
                    // 将转义后的参数键值对添加到新的映射中
                    encodedMap.put(entry.getKey(), encodedValues);
                }
            }
            // 返回转义后的参数键值对映射
            return encodedMap;
        }
    }
}