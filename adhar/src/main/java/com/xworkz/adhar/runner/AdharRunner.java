package com.xworkz.adhar.runner;

import com.xworkz.adhar.entity.AdharEntity;
import com.xworkz.adhar.service.AdharEntityService;
import com.xworkz.adhar.service.AdharEntityServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class AdharRunner {

    public static void main(String[] args) {


        System.out.println("Running main method");

        List<AdharEntity> adharEntityList = new ArrayList<>();
        adharEntityList.add(new AdharEntity("Roshan", 21, 9110863479L, "roshannaik202055@gmail.com"));
        adharEntityList.add(new AdharEntity("Ananya", 22, 9812345670L, "ananya.k@example.com"));
        adharEntityList.add(new AdharEntity("Rahul", 25, 9876543210L, "rahul.m@example.com"));
        adharEntityList.add(new AdharEntity("Sneha", 23, 9123456789L, "sneha.v@example.com"));
        adharEntityList.add(new AdharEntity("Amit", 26, 9345678901L, "amit.p@example.com"));
        adharEntityList.add(new AdharEntity("Pooja", 24, 9445678902L, "pooja.s@example.com"));
        adharEntityList.add(new AdharEntity("Kiran", 27, 9556789012L, "kiran.r@example.com"));
        adharEntityList.add(new AdharEntity("Divya", 20, 9667890123L, "divya.k@example.com"));
        adharEntityList.add(new AdharEntity("Manoj", 29, 9778901234L, "manoj.j@example.com"));
        adharEntityList.add(new AdharEntity("Neha", 28, 9889012345L, "neha.b@example.com"));
        adharEntityList.add(new AdharEntity("Suresh", 30, 9990123456L, "suresh.n@example.com"));
        adharEntityList.add(new AdharEntity("Lakshmi", 19, 9001234567L, "lakshmi.l@example.com"));
        adharEntityList.add(new AdharEntity("Vikas", 22, 9112345678L, "vikas.t@example.com"));
        adharEntityList.add(new AdharEntity("Meena", 21, 9223456789L, "meena.w@example.com"));
        adharEntityList.add(new AdharEntity("Ramesh", 24, 9334567890L, "ramesh.u@example.com"));
        adharEntityList.add(new AdharEntity("Geeta", 26, 9445678901L, "geeta.z@example.com"));
        adharEntityList.add(new AdharEntity("Arjun", 28, 9556789012L, "arjun.y@example.com"));
        adharEntityList.add(new AdharEntity("Deepika", 23, 9667890123L, "deepika.q@example.com"));
        adharEntityList.add(new AdharEntity("Sunil", 27, 9778901234L, "sunil.e@example.com"));
        adharEntityList.add(new AdharEntity("Kavya", 25, 9889012345L, "kavya.f@example.com"));

        AdharEntityService adharEntityService = new AdharEntityServiceImpl();
        boolean result = adharEntityService.addAll(adharEntityList);
        System.out.println("Data saved : "+result);

    }

}
