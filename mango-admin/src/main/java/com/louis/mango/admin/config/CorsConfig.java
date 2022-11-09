package com.louis.mango.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Discription: ${Discription}
 * @ClassName: ${ClassName}
 * @Author: huangjinming
 * @Date: 2021/7/24 22:47
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//允许跨域访问路径
                .allowedOrigins("*")//允许跨域访问资源
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")//允许请求方法
                .maxAge(168000).allowedHeaders("*").allowCredentials(true);
    }
}
