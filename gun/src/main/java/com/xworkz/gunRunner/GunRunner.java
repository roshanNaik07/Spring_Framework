package com.xworkz.gunRunner;

import com.xworkz.entity.GunEntity;
import com.xworkz.entity.GunVendor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class GunRunner {

    public static void main(String[] args) {

       EntityManagerFactory eMF = Persistence.createEntityManagerFactory("gun");
       EntityManager entityManager = eMF.createEntityManager();
       EntityTransaction entityTransaction = entityManager.getTransaction();

       entityTransaction.begin();

        List<GunEntity> list = new ArrayList<>();
        list.add(new GunEntity(1,"P51",15000,"black",400,"Roshan"));
        list.add(new GunEntity(2,"P90",21000,"metalic",375,"JohnWick"));
        list.add(new GunEntity(3,"Revolver",25000,"metalic",555,"Rockey"));
        list.add(new GunEntity(4,"Uzi",45000,"black",600,"Scout"));
        list.add(new GunEntity(5,"P5",18000,"metalic",450,"Jonathan"));

        for (GunEntity ref : list){
            entityManager.persist(ref);
        }

        List<GunVendor> list1 = new ArrayList<>();
        list1.add(new GunVendor(1,"Shots",1969,"US",5,"John Doe"));
        list1.add(new GunVendor(2, "Trigger Point", 1985, "Germany", 4, "Alice Smith"));
        list1.add(new GunVendor(3, "BulletZone", 2001, "Canada", 5, "Robert Lee"));
        list1.add(new GunVendor(4, "Arsenal Hub", 1995, "Russia", 3, "Ivan Petrov"));
        list1.add(new GunVendor(5, "Firearm Central", 2010, "India", 4, "Amit Raj"));

        for (GunVendor ref : list1){
            entityManager.persist(ref);
        }

        entityTransaction.commit();

       GunEntity entity1 = entityManager.find(GunEntity.class,4);
        System.out.println(entity1);

        entityManager.close();
        eMF.close();
    }

}
