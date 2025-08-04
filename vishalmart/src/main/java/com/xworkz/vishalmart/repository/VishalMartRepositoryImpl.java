package com.xworkz.vishalmart.repository;

import com.xworkz.vishalmart.entity.VishalMartEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class VishalMartRepositoryImpl implements VishalMartRepository{
    @Override
    public VishalMartEntity saveData(VishalMartEntity vishalMartEntity) {

        System.out.println("Running VishalMartRepoImpl ");

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{

            entityManagerFactory = Persistence.createEntityManagerFactory("shopping");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            if(vishalMartEntity != null){
                entityManager.persist(vishalMartEntity);
            }else {
                System.out.println("vishalMartEntity is pointing to null");
            }

            System.out.println("Data added successfully");

            entityTransaction.commit();

        }catch (Exception e){

            if (entityTransaction.isActive()){
                entityTransaction.rollback();
            }

        }finally {

            entityManagerFactory.close();

        }

        return null;
    }
}
