package com.xworkz.dominos.repository;

import com.xworkz.dominos.entity.DominosEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class DominosRepositoryImpl implements DominosRepository{

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("domino's");

    @Override
    public boolean saveData(DominosEntity entity) {
        System.out.println("Running saveData Domino'sRepositoryImpl");
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
    public List<DominosEntity> fetchDetails() {
        System.out.println("Running fetchDetails in Domino'sRepositoryImpl");
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<DominosEntity> list = new ArrayList<>();
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Query query = entityManager.createNamedQuery("getAllDetails");
            entityTransaction.commit();

            return list = query.getResultList();

        }catch (Exception e){

            if (entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            e.printStackTrace();

        }finally {
            entityManager.close();
        }

        return null;
    }

    @Override
    public DominosEntity getById(int id) {

        System.out.println("Running getById in Domino'sRepositoryImpl");
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        DominosEntity entity ;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Query query = entityManager.createNamedQuery("getEntityById");
            query.setParameter("id",id);
            entity = (DominosEntity) query.getSingleResult();
            entityTransaction.commit();

            return entity;

        }catch (Exception e){

            if (entityTransaction.isActive()){
                entityTransaction.rollback();
            }e.printStackTrace();

        }finally {
            entityManager.close();
        }

        return null;
    }

    @Override
    public boolean updateById(int id, DominosEntity dominosEntity) {

        System.out.println("Running updateById in Domino'sRepositoryImpl");
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        DominosEntity entity ;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entity = entityManager.find(DominosEntity.class,id);
            entity.setName(dominosEntity.getName());
            entity.setEmail(dominosEntity.getEmail());
            entity.setPhoneNo(dominosEntity.getPhoneNo());
            entity.setPrice(dominosEntity.getPrice());
            entityManager.merge(entity);
            entityTransaction.commit();
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

    @Override
    public boolean deleteById(int id) {
        System.out.println("Running deleteById in Domino'sRepositoryImpl");
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        DominosEntity entity ;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Query query = entityManager.createNamedQuery("deleteById");
            query.setParameter("id",id);
            query.executeUpdate();

            entityTransaction.commit();
            System.out.println("deleted successfully");
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

    @Override
    public List<DominosEntity> getDomainList(String domain) {

        System.out.println("Running getDomainList in Domino'sRepositoryImpl");
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<DominosEntity> list = new ArrayList<>();
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Query query = entityManager.createNamedQuery("domainType");
            query.setParameter("domain",domain);
            list = query.getResultList();
            entityTransaction.commit();

            return list;

        }catch (Exception e){
            if (entityTransaction.isActive()){
                entityTransaction.rollback();
            }e.printStackTrace();

        }finally {
            entityManager.close();
        }

        return Collections.emptyList();
    }

    @Override
    public List<String> getNamesAbovePrice(int price) {

        System.out.println("Running getNamesAbovePrice in Domino'sRepositoryImpl");
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<String> list ;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Query query = entityManager.createNamedQuery("findNameAbovePrice");
            query.setParameter("price",price);
            list = query.getResultList();
            entityTransaction.commit();

            return list;

        }catch (Exception e){
            if (entityTransaction.isActive()){
                entityTransaction.rollback();
            }e.printStackTrace();

        }finally {
            entityManager.close();
        }

        return Collections.emptyList();
    }
}
