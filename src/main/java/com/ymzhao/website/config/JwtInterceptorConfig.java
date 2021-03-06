package com.ymzhao.website.config;

import com.ymzhao.website.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * Create By ymzhao on 2021/3/11
 */
@Configuration
public class JwtInterceptorConfig extends WebMvcConfigurationSupport {

    @Resource
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器，要声明拦截器对象和要拦截的请求
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/zymwb/**") //所有路径都被拦截
                .excludePathPatterns("/zymwb/login/**") // 排除用户登录请求
                .excludePathPatterns("/zymwb/register/**") // 排除用户注册请求
                .excludePathPatterns("/error");
        super.addInterceptors(registry);
    }

    /**
     * 用来指定静态资源不被拦截，否则继承WebMvcConfigurationSupport这种方式会导致静态资源无法直接访问
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

}
