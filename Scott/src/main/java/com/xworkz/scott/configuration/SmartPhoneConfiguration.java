package com.xworkz.scott.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.xworkz.scott.smartPhone")
public class SmartPhoneConfiguration {

    public SmartPhoneConfiguration() {
        System.out.println("SmartPhoneConfiguration");

    }

    @Bean
    public Float[] getModelNo() {
        System.out.println("getModelNo instance created by ApplicationContext");
        return new Float[]{2.4f, 56.5f, 248.56f, 5.6f, 2.1f};
    }

    @Bean
    public Double[] getIp() {
        System.out.println("getIP instance created by ApplicationContext");
        return new Double[]{2.322665444, 5.464878941215, 15.3464646534654};
    }

    @Bean
    public Boolean[] stockAvailable() {
        System.out.println("stockAvailable instance created by ApplicationContext");
        return new Boolean[]{true, false, false, true, false, true, false, true};
    }

    @Bean
    public List<String> getProductNames() {
        System.out.println("getProductNames instance created by ApplicationContext");
        return Arrays.asList("Laptop", "Mobile", "Tablet", "Monitor", "Keyboard");
    }

    @Bean
    public ArrayList<Integer> getProductCodes() {
        System.out.println("getProductCodes instance created by ApplicationContext");
        return new ArrayList<>(Arrays.asList(101, 102, 103, 104, 105));
    }

    @Bean
    public LinkedList<Double> getDiscounts() {
        System.out.println("getDiscounts instance created by ApplicationContext");
        return new LinkedList<>(Arrays.asList(2.6646, 6546.1655545, 2.6464646));
    }

    @Bean
    public List<Boolean> isProductActive() {
        System.out.println("isProductActive instance created by ApplicationContext");
        return Arrays.asList(true, true, false, true, false);
    }

    @Bean
    public ArrayList<Character> getProductGrades() {
        System.out.println("getProductGrades instance created by ApplicationContext");
        ArrayList<Character> arrayList = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'A', 'B'));
        return arrayList;
    }

    @Bean
    public LinkedList<Long> getSerialNumbers() {
        System.out.println("getSerialNumbers instance created by ApplicationContext");
        System.out.println("------------------------------------------------------");
        return new LinkedList<>(Arrays.asList(1234567890L, 9876543210L, 1122334455L));
    }
}
