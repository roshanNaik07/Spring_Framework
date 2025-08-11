package com.xworkz.adhar.runner;

import com.xworkz.adhar.entity.AdharEntity;
import com.xworkz.adhar.service.AdharEntityService;
import com.xworkz.adhar.service.AdharEntityServiceImpl;

public class AdharGetNameAndAge {

    public static void main(String[] args) {

        AdharEntityService adharEntityService =new AdharEntityServiceImpl();
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println("Get by name and age :");
        AdharEntity entity1 = adharEntityService.findBYNameAndAge("Meena",21);
        System.out.println(entity1);

    }

}
