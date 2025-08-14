package com.xworkz.dominos.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.dominos")
public class DominosConfiguration {

    public DominosConfiguration(){
        System.out.println("No arg const of DominosConfiguration");
    }

}
