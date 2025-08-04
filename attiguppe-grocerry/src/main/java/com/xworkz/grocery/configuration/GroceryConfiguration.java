package com.xworkz.grocery.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.grocery.component")
public class GroceryConfiguration {

    public GroceryConfiguration(){
        System.out.println("GroceryConfiguration created by Spring[AC}");
    }

}
