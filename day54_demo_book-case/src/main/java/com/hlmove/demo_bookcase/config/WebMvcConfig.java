package com.hlmove.demo_bookcase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Hlmove
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * 静态资源配置  默认映射static目录，
     * addResourceHandler 修改访问的路径
     * addResourceLocations classpath 映射的目录 src/main/resource:
     * classpath 此时走的是http协议
     * file  可以访问磁盘资源
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        registry.addResourceHandler("/pages/**").addResourceLocations("classpath:/pages/");
        registry.addResourceHandler("/elementui/**").addResourceLocations("classpath:/elementui/");
        //访问路径名
        registry.addResourceHandler("/static/**").addResourceLocations("file:G:/beifen/software/picture/");
//        //既想要访问swagger页面，又想要访问我们自己写的页面
//        //新增代码
//        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        //既想要访问doc.html页面，又想要访问我们自己写的页面
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
