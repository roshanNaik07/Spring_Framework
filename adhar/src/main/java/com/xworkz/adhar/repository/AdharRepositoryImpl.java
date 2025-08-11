package com.xworkz.adhar.repository;

import com.xworkz.adhar.entity.AdharEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class AdharRepositoryImpl implements AdharRepository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("adhar");;

    @Override
    public boolean addAll(List<AdharEntity> list) {

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{

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

        EntityManager entityManager= null;
        EntityTransaction entityTransaction = null;
        AdharEntity adharEntity = null;
        try{

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

    @Override
    public AdharEntity findByNameAndAge(String name, int age) {

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        AdharEntity adharEntity = null;

        try{

            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            TypedQuery<AdharEntity> query = entityManager.createNamedQuery("getByNameAndAge", AdharEntity.class);
            query.setParameter("name",name);
            query.setParameter("age",age);
            adharEntity = query.getSingleResult();

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

    @Override
    public List<AdharEntity> getByAgeAbove(int age) {

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<AdharEntity> adharEntityList = null;
        try{

            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            TypedQuery<AdharEntity> query = entityManager.createNamedQuery("getAgeAbove", AdharEntity.class);
            query.setParameter("age",age);
            adharEntityList = query.getResultList();

            entityTransaction.commit();

        }catch (Exception e){
            if (entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            e.fillInStackTrace();
        }finally {
            entityManager.close();
        }

        return adharEntityList;
    }

    @Override
    public List<AdharEntity> getAgeBetween(int age1, int age2) {

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<AdharEntity> adharEntityList = null;
        try{


            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            TypedQuery<AdharEntity> query = entityManager.createNamedQuery("getAgeAboveBetween", AdharEntity.class);
            query.setParameter("age1",age1);
            query.setParameter("age2",age2);
            adharEntityList = query.getResultList();

            entityTransaction.commit();

        }catch (Exception e){
            if (entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            e.fillInStackTrace();
        }finally {
            entityManager.close();
        }

        return adharEntityList;
    }

    @Override
    public String getNameByEmail(String email) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
       String name=null;
        try {


            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();


            entityTransaction.begin();
            Query query=entityManager.createNamedQuery("getNameByEmail");

            query.setParameter("emailBy",email);
            name =(String) query.getSingleResult();


            entityTransaction.commit();

        }catch (Exception e){

            if (entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }
        return name;
    }

    @Override
    public AdharEntity getPhoneAndNameByEmail(String email) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        AdharEntity adharEntity =new AdharEntity();
      try{
          entityManager=entityManagerFactory.createEntityManager();
          entityTransaction = entityManager.getTransaction();
          entityTransaction.begin();
         Query query= entityManager.createNamedQuery("getPhoneNumberAndNameByEmail");

         query .setParameter("emailBy",email);
       Object[] objects = (Object[]) query.getSingleResult();
          for(Object adharEntity1 : objects) {
              System.out.println(adharEntity1);
          }

       Long phoneNumber = (Long) objects[0];
          adharEntity.setPh(phoneNumber);
          String name =(String) objects[1];
          adharEntity.setName(name);

          entityTransaction.commit();

      }catch(Exception e) {
          if (entityTransaction.isActive()) {
              entityTransaction.rollback();

          }
      }finally {
          entityManager.close();
      }

        return adharEntity;
    }
}

