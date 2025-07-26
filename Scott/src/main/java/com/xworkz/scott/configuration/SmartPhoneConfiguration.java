package com.xworkz.scott.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.scott.smartPhone")
public class SmartPhoneConfiguration {

    public SmartPhoneConfiguration() {
        System.out.println("SmartPhoneConfiguration");

    }


}
