package com.xworkz.training.runner;

import com.xworkz.training.entity.TrainingEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class TrainingRunner {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("training");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        List<TrainingEntity> list = new ArrayList<>();
        list.add(new TrainingEntity(1,"xworkz","Rajajinagar","Om",2020,60));
        list.add(new TrainingEntity(2, "JSpiders", "BTM Layout", "Sunil", 2019, 45));
        list.add(new TrainingEntity(3, "Pentagon Space", "Marathahalli", "Kiran", 2021, 50));
        list.add(new TrainingEntity(4, "Kodnest", "Basavanagudi", "Ramesh", 2022, 40));

        for (TrainingEntity ref : list){
            entityManager.persist(ref);
        }

        entityTransaction.commit();
        TrainingEntity entity = entityManager.find(TrainingEntity.class,3);
        System.out.println(entity);
        emf.close();

    }

}
