package com.xworkz.dmart.runner;

import com.xworkz.dmart.entity.DmartEntity;
import com.xworkz.dmart.service.DmartService;
import com.xworkz.dmart.service.DmartServiceImpl;

public class DmartRunner {

    public static void main(String[] args) {

        System.out.println("Running main method");

//        DmartEntity dmartEntity = new DmartEntity(3,"Attiguppe","Mug","material");

        DmartService dmartService = new DmartServiceImpl();

//        dmartService.save(dmartEntity);


        //getProductById
        DmartEntity dmartEntity = dmartService.getEntityById(3);
        System.out.println(dmartEntity);

        boolean result = dmartService.updateProductById(3 , "Spoon");
        System.out.println(result);

        boolean result2 = dmartService.deleteEntityById(2);
        System.out.println(result2);
    }

}
