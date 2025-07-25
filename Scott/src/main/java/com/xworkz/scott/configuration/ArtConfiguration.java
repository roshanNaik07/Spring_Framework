package com.xworkz.scott.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.scott.art")
public class ArtConfiguration {

    public ArtConfiguration(){
        System.out.println("No arg constructor of ArtConfiguration");
    }

    @Bean
    public Byte artCount(){
        System.out.println("artCount instance created by ApplicationContext");
        return 5;
    }

    @Bean
    public Float artWorkHeight(){
        System.out.println("artWorkHeight instance created by ApplicationContext");
        return 5.6F;
    }

    @Bean
    public Double canvasLength(){
        System.out.println("canvasHeight instance created by ApplicationContext");
        return 465.445545;
    }

    @Bean
    public Boolean artAvailability(){
        System.out.println("artAvailability instance created by ApplicationContext");
        return false;
    }

    @Bean
    public Character artUniqueChar(){
        System.out.println("artUniqueChar instance created by ApplicationContext");
        return 'K';
    }

    @Bean
    public int[] artStack(){
        System.out.println("artStack instance created by ApplicationContext");
        return new int[]{2,5,6,4,8};
    }

    @Bean
    public String[] artNames(){
        System.out.println("artNames instance created by ApplicationContext");
        return new String[]{"monalisa","manja","Kola"};
    }

    @Bean
    public byte[] a4Works(){
        System.out.println("a4Works instance created by ApplicationContext");
        return new byte[]{65,86,44,33};
    }

    @Bean
    public char[] artBatches(){
        System.out.println("artBatches instance created by ApplicationContext");
        return new char[]{'A','G','L','w'};
    }

    @Bean
    public long[] artistNos(){
        System.out.println("artistNos instance created by ApplicationContext");
        return new long[]{516464655565l,654564665l,4545544415616l};
    }
}
