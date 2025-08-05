package com.xworkz.gym.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GymComponent {

    private Owner owner;

    @Autowired
    public GymComponent(Owner owner){
        this.owner = owner;
    }

    public int noOfFloors(){
        System.out.println("no of floor is found");
        return 3;
    }

    public void getOwnerDetail(){
        System.out.println("Owner name found");
        owner.getOwnerName();
    }


}
