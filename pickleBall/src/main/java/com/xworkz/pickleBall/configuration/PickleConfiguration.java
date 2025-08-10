package com.xworkz.pickleBall.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "com.xworkz.pickleBall")
@EnableWebMvc
public class PickleConfiguration implements WebMvcConfigurer {

    public PickleConfiguration(){
        System.out.println("pickleConfiguration created by Spring container");
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("pickleBall.png").addResourceLocations("/images/*");

    }


}
