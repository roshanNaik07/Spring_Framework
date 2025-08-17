package com.xworkz.dominos.repository;

import com.xworkz.dominos.entity.DominosEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
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
}
