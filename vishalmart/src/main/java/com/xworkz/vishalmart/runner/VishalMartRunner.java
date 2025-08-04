package com.xworkz.vishalmart.runner;

import com.xworkz.vishalmart.entity.VishalMartEntity;
import com.xworkz.vishalmart.service.VishalMartService;
import com.xworkz.vishalmart.service.VishalMartServiceImpl;

public class VishalMartRunner {

    public static void main(String[] args) {

        System.out.println("Running main method");

        VishalMartEntity vishalMartEntity = new VishalMartEntity(1,"Attiguppe",2,"Biscuit");
        VishalMartEntity vishalMartEntity1 = new VishalMartEntity(2,"Vijayanagar",3,"T-shirt");

        VishalMartService vishalMartService = new VishalMartServiceImpl();
        vishalMartService.save(vishalMartEntity1);

    }

}
