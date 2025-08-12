package com.xworkz.adhar.runner;

import com.xworkz.adhar.entity.AdharEntity;
import com.xworkz.adhar.service.AdharEntityService;
import com.xworkz.adhar.service.AdharEntityServiceImpl;

public class AdharGetByAgeAndPh {

    public static void main(String[] args) {

        AdharEntityService adharEntityService = new AdharEntityServiceImpl();
        AdharEntity entity = adharEntityService.getEntityByAgeAndPhoneNo(21,9110863479l);
        System.out.println(entity);

    }

}
