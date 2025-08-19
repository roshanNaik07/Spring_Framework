package com.xworkz.travel.repository;

import com.xworkz.travel.entity.BgmiEntity;
import com.xworkz.travel.entity.StudentEntity;
import com.xworkz.travel.entity.TrainingEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Repository
public class TravelRepositoryImpl implements TravelRepository{

    boolean saveData(Object entity){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("travel");
        System.out.println("Running saveData TravelRepositoryImpl");
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(entity);
            entityTransaction.commit();
            System.out.println("Data saved successfully");
            return true;

        }catch (Exception e){
            if (entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }

        return false;
    }

    @Override
    public boolean saveStudentData(StudentEntity studentEntity) {
        return saveData(studentEntity);
    }

    @Override
    public boolean saveTrainingData(TrainingEntity trainingEntity) {
        return saveData(trainingEntity);

    }

    @Override
    public boolean saveBgmiData(BgmiEntity bgmiEntity) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("travel");
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{

            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(bgmiEntity);

            entityTransaction.commit();
            System.out.println("data saved");

            return true;
        }catch (Exception e){
            if (entityTransaction.isActive()){
                entityTransaction.rollback();
            }e.printStackTrace();
        }finally {
            entityManager.close();
        }

        return false;
    }

}
