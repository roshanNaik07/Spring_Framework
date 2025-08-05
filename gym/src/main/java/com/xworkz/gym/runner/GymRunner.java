package com.xworkz.gym.runner;

import com.xworkz.gym.configuration.GymConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class GymRunner {

    public static void main(String[] args) {

        System.out.println("Running main method");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GymConfiguration.class);

        GymComponent component = context.getBean(GymComponent.class);
        component.noOfFloors();
        component.getOwnerDetail();
        context.close();

    }

}
