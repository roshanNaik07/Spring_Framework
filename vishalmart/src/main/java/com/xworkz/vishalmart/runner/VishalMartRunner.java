package com.xworkz.vishalmart.runner;

import com.xworkz.vishalmart.entity.VishalMartEntity;
import com.xworkz.vishalmart.service.VishalMartService;
import com.xworkz.vishalmart.service.VishalMartServiceImpl;

public class VishalMartRunner {

    public static void main(String[] args) {

        System.out.println("Running main method");

//        VishalMartEntity vishalMartEntity = new VishalMartEntity(1,"Attiguppe",2,"Biscuit");
//        VishalMartEntity vishalMartEntity1 = new VishalMartEntity(2,"Vijayanagar",3,"T-shirt");

//        VishalMartEntity vishalMartEntity2 = new VishalMartEntity(3, "Navrang", 3, "Frok");
//        VishalMartEntity vishalMartEntity3 = new VishalMartEntity(4,"Magadi",5,"Shirt");

        VishalMartService vishalMartService = new VishalMartServiceImpl();
//       vishalMartService.save(vishalMartEntity3);

        VishalMartEntity vishalMartEntity = vishalMartService.findEntityById(3);
        System.out.println(vishalMartEntity);

        boolean result = vishalMartService.updateLocationById(1,"Sirsi");
        System.out.println(result);

        boolean result2 = vishalMartService.deleteEntityById(4);
        System.out.println(result2);
    }

}
