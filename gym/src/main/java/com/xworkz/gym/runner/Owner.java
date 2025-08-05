package com.xworkz.gym.runner;

import org.springframework.stereotype.Service;

@Service
public class Owner {

    public String getOwnerName(){
        System.out.println("Found owner name");
        return "Akash";
    }

}
