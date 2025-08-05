package com.xworkz.gym.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.gym")
public class GymConfiguration {

    public GymConfiguration(){
        System.out.println("No arg const of GymConfiguration");
    }

    @Bean
    public String getName(){
        System.out.println("Found gym name");
        return "Cult fitness";
    }
}
