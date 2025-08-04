package com.xworkz.dmart.runner;

import com.xworkz.dmart.entity.DmartEntity;
import com.xworkz.dmart.service.DmartService;
import com.xworkz.dmart.service.DmartServiceImpl;

public class DmartRunner {

    public static void main(String[] args) {

        System.out.println("Running main method");

        DmartEntity dmartEntity = new DmartEntity(2,"BTM","Book","stationary");

        DmartService dmartService = new DmartServiceImpl();
        dmartService.save(dmartEntity);

    }

}
