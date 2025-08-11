package com.xworkz.adhar.runner;

import com.xworkz.adhar.entity.AdharEntity;
import com.xworkz.adhar.service.AdharEntityService;
import com.xworkz.adhar.service.AdharEntityServiceImpl;

import java.util.List;

public class AdharAgeBetween {

    public static void main(String[] args) {

        AdharEntityService adharEntityService =new AdharEntityServiceImpl();

        System.out.println();
        System.out.println("Get age between : ");
        List<AdharEntity> adharEntityList1 = adharEntityService.getAgeBetween(23,28);

        for (AdharEntity ref : adharEntityList1){
            System.out.println(ref);
        }

    }

}
