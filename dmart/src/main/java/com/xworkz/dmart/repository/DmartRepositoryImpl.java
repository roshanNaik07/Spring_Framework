package com.xworkz.dmart.repository;

import com.xworkz.dmart.entity.DmartEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DmartRepositoryImpl implements DmartRepository {

    public DmartRepositoryImpl() {
        System.out.println("Running DmartRepoIml no arg constructor");
    }

    @Override
    public DmartEntity saveData(DmartEntity dmartEntity) {

        System.out.println("Running saveData()");
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("shopping");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(dmartEntity);
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
        } finally {
            entityManagerFactory.close();
        }
        return null;
    }

    @Override
    public DmartEntity getEntityById(int id) {
        System.out.println("Running getProductById() in DmartRepositoryImpl");

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        DmartEntity dmartEntity = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("shopping");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            if (id != 0) {
                dmartEntity = entityManager.find(DmartEntity.class, id);
            }

            entityTransaction.commit();

        } catch (Exception e) {

            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }

        } finally {
            entityManager.close();
        }

        return dmartEntity;
    }

    @Override
    public boolean updateProductById(int id, String product) {

        System.out.println("Running updateProductById in DmartRepositoryImpl");

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        DmartEntity entity = null;
        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("shopping");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            entity = entityManager.find(DmartEntity.class, id);
            if (entity != null) {
                entity.setProduct(product);
                System.out.println("Product updated to : " + entity.getProduct());
            }
            entityTransaction.commit();
            return true;

        } catch (Exception e) {

            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }

        } finally {

            entityManager.close();

        }

        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {

        System.out.println("Running deleteEntityById in DmartRepositoryImpl");

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        DmartEntity entity = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("shopping");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            entity = entityManager.find(DmartEntity.class,id);
            if (entity!= null){
                entityManager.remove(entity);
            }
            entityTransaction.commit();
            return true;
        } catch (Exception e) {

            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }

        } finally {
            entityManager.close();
        }

        return false;
    }

}
