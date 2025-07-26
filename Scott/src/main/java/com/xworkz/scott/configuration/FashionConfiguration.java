package com.xworkz.scott.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.scott.fashion")
public class FashionConfiguration {

    public FashionConfiguration(){
        System.out.println("FashionConfiguration no arg const");
    }

}
