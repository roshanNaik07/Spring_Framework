package com.xworkz.scott.transport;

import org.springframework.stereotype.Component;

@Component
public class YellowBoard {

    public YellowBoard(){
        System.out.println("YellowBoard instance created by spring");
        System.out.println("------------------------------------");
    }

}
