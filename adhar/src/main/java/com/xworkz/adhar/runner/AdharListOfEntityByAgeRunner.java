package com.xworkz.adhar.runner;

import com.xworkz.adhar.entity.AdharEntity;
import com.xworkz.adhar.service.AdharEntityService;
import com.xworkz.adhar.service.AdharEntityServiceImpl;

import java.util.List;

public class AdharListOfEntityByAgeRunner {

    public static void main(String[] args) {

        System.out.println("Running main");
        AdharEntityService adharEntityService = new AdharEntityServiceImpl();
        List<AdharEntity> list = adharEntityService.getListOfEntityByAge(22);
        System.out.println("after the get operation");

        for (AdharEntity ref : list){
            System.out.println(ref);
        }
    }

}
