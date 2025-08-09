package com.xworkz.grocery.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "com.xworkz.grocery.component")
@EnableWebMvc
public class GroceryConfiguration implements WebMvcConfigurer {

    public GroceryConfiguration(){
        System.out.println("GroceryConfiguration created by Spring[AC}");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/images/**")
                .addResourceLocations("/images/");
    }
}
