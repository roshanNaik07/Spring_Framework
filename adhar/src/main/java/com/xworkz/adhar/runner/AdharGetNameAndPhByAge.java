package com.xworkz.adhar.runner;

import com.xworkz.adhar.entity.AdharEntity;
import com.xworkz.adhar.service.AdharEntityService;
import com.xworkz.adhar.service.AdharEntityServiceImpl;

import java.util.List;

public class AdharGetNameAndPhByAge {

    public static void main(String[] args) {

        AdharEntityService adharEntityService = new AdharEntityServiceImpl();
        List<AdharEntity> list =adharEntityService.getNameAndPhByAge(21);
        for (AdharEntity ref : list){
            System.out.println("Name is : "+ref.getName());
            System.out.println("Phone No is : "+ref.getPh());
        }
    }

}
