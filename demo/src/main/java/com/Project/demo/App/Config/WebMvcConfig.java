package com.Project.demo.App.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

public class WebMvcConfig implements WebMvcConfigurer {

    @Bean(name="SimpleMappingExeptionResolver")
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){

        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.setProperty("SpringBlogException","genericError");
        mappings.setProperty("RuntimeException","Error");
        exceptionResolver.setExceptionMappings(mappings);
        exceptionResolver.setDefaultErrorView("error");

        return exceptionResolver;

    }


}
