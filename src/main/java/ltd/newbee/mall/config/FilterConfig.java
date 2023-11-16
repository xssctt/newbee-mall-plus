package ltd.newbee.mall.config;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import ltd.newbee.mall.web.filter.XssFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Configuration表示这是一个配置类
 * @ConditionalOnProperty表示只有当xss.enabled=true时这个配置才会生效
 * 从配置文件中获取excludes和urlPatterns的值
 * 定义一个FilterRegistrationBean来注册XssFilter
 * 设置过滤器只作用在REQUEST请求上
 * 添加要过滤的url模式
 * 设置过滤器名称
 * 顺序设置为最高优先级
 * 设置过滤器的初始化参数,excludes表示不过滤的路径
 * 返回注册的FilterRegistrationBean
 * 这样就完成了XssFilter的注册。它会对所有请求进行XSS过滤,但排除在excludes路径之外的请求。
 * Filter配置
 */
@Configuration
@ConditionalOnProperty(value = "xss.enabled", havingValue = "true")
public class FilterConfig {
    @Value("${xss.excludes}")
    private String excludes;

    @Value("${xss.urlPatterns}")
    private String urlPatterns;

    @Bean
    public FilterRegistrationBean<Filter> xssFilterRegistration() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new XssFilter());
        registration.addUrlPatterns(StringUtils.split(urlPatterns, ","));
        registration.setName("xssFilter");
        registration.setOrder(FilterRegistrationBean.HIGHEST_PRECEDENCE);
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("excludes", excludes);
        registration.setInitParameters(initParameters);
        return registration;
    }
}
