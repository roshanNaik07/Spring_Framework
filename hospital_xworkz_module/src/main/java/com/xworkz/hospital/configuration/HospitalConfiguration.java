package com.xworkz.hospital.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "com.xworkz.hospital")
@EnableWebMvc
@Slf4j
@PropertySource("classpath:application.properties")
public class HospitalConfiguration implements WebMvcConfigurer {

    public HospitalConfiguration() {
        log.info("No arg const of HospitalConfiguration");
    }

    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configure) {
        configure.enable();
    }

    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/", ".jsp");
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver() {

        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(1048576);
        commonsMultipartResolver.setMaxInMemorySize(1048576);
        return commonsMultipartResolver;
    }

}
