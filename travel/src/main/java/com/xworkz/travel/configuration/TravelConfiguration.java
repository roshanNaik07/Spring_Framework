package com.xworkz.travel.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.xworkz.travel")
public class TravelConfiguration implements WebMvcConfigurer {

    public TravelConfiguration(){
        System.out.println("TravelConfiguration created by Web Application Context");
    }

    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


}
