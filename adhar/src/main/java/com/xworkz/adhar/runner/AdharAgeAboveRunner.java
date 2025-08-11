package com.xworkz.adhar.runner;

import com.xworkz.adhar.entity.AdharEntity;
import com.xworkz.adhar.service.AdharEntityService;
import com.xworkz.adhar.service.AdharEntityServiceImpl;

import java.util.List;

public class AdharAgeAboveRunner {

    public static void main(String[] args) {

        AdharEntityService adharEntityService =new AdharEntityServiceImpl();
        System.out.println();
        System.out.println("---------------------------------------------------------");
        System.out.println("Find entity's where age is above 18");
        List<AdharEntity> adharEntityList = adharEntityService.getByAgeAbove(28);

        for (AdharEntity ref : adharEntityList){
            System.out.println(ref);
        }


    }

}
