package com.xworkz.adhar.runner;

import com.xworkz.adhar.entity.AdharEntity;
import com.xworkz.adhar.service.AdharEntityService;
import com.xworkz.adhar.service.AdharEntityServiceImpl;

public class AdharGetNameRunner {

    public static void main(String[] args) {

        AdharEntityService adharEntityService = new AdharEntityServiceImpl();
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("Find by name : ");
        AdharEntity entity = adharEntityService.findByName("Manoj");
        System.out.println(entity);

    }

}
