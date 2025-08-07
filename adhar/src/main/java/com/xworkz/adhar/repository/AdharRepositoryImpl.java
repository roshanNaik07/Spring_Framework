package com.xworkz.adhar.repository;

import com.xworkz.adhar.entity.AdharEntity;

import javax.persistence.*;
import java.util.List;

public class AdharRepositoryImpl implements AdharRepository {


    @Override
    public boolean addAll(List<AdharEntity> list) {

        EntityManagerFactory entityManagerFactory = null ;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{

            entityManagerFactory = Persistence.createEntityManagerFactory("adhar");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            for (AdharEntity ref : list){
                entityManager.persist(ref);
            }

            entityTransaction.commit();

            return true ;

        }catch(Exception e){

            if (entityTransaction.isActive()){
                entityTransaction.rollback();
            }
           e.fillInStackTrace();

        }finally {
            entityManager.close();
        }

        return false;
    }

    @Override
    public AdharEntity findByName(String name) {

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager= null;
        EntityTransaction entityTransaction = null;
        AdharEntity adharEntity = null;
        try{

            entityManagerFactory = Persistence.createEntityManagerFactory("adhar");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();

            entityTransaction.begin();

            TypedQuery<AdharEntity> query = entityManager.createNamedQuery("findByName",AdharEntity.class);

            query.setParameter("name",name);

            adharEntity =query.getSingleResult();

            entityTransaction.commit();

        }catch (Exception e){

            if (entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            e.fillInStackTrace();

        }finally {
            entityManager.close();
        }

        return adharEntity;
    }
}
