package com.xworkz.scott.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.scott.transport")
public class TransportConfiguration {

    public TransportConfiguration(){
        System.out.println(" no arg constructor of TransportConfiguration ");
    }

    @Bean
    public int price(){
        System.out.println("Price instance by ApplicationContext");
        return 123;
    }

    @Bean
    public String roadName(){
        System.out.println("roadName instance by ApplicationContext");
        return "Nataraj road";
    }

    @Bean
    public long getTollNo(){
        System.out.println("getTollNo instance by ApplicationContext");
        return 108;
    }

    @Bean
    public Boolean rulesApplied(){
        System.out.println("rulesApplied instance by ApplicationContext");
        return true;
    }

    @Bean
    public char batch(){
        System.out.println("batch instance by ApplicationContext");
        return 'A';
    }

    @Bean
    public float getKm(){
        System.out.println("km instance by ApplicationContext");
        return 2.5f;
    }

    @Bean
    public double getTiming(){
        System.out.println("getTiming instance by ApplicationContext");
        return 123.25646;
    }

    @Bean
    public byte count(){
        System.out.println("count instance by ApplicationContext");
        return 2;
    }

    @Bean
    public Integer bikeSeized(){
        System.out.println("bikeSeized instance by ApplicationContext");
        return 150;
    }

    @Bean
    public Long vehicleInCity(){

        System.out.println("VehicleInCity instance by ApplicationContext");
        System.out.println("---------------------------------------------");
        return 1616516516L;

    }
}
