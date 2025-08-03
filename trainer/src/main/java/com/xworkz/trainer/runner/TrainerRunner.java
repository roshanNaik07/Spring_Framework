package com.xworkz.trainer.runner;

import com.xworkz.trainer.entity.TrainerEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TrainerRunner {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("trainer");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try {
            //add of new value
            TrainerEntity entity1 = new TrainerEntity(4,"Rohan",35,"mysql");
            TrainerEntity entity2 = new TrainerEntity(5,"prajwal",41,"Collections");

            entityManager.merge(entity1);
            entityManager.merge(entity2);

            //updating the value
            TrainerEntity entity = entityManager.find(TrainerEntity.class,4);
            if (entity!= null){
                entity.setName("prasanna");
            }

            TrainerEntity trainerEntity =  entityManager.find(TrainerEntity.class,2);
            if (trainerEntity != null){
                entityManager.remove(trainerEntity);
            }
            entityTransaction.commit();
        }
        catch (Exception e){
            System.out.println("couldn't get the connection");
        }
        finally {
            entityManagerFactory.close();
        }

    }

}
