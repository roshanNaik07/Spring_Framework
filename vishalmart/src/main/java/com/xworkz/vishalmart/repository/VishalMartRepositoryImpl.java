package com.xworkz.vishalmart.repository;

import com.xworkz.vishalmart.entity.VishalMartEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class VishalMartRepositoryImpl implements VishalMartRepository {
    @Override
    public VishalMartEntity saveData(VishalMartEntity vishalMartEntity) {

        System.out.println("Running VishalMartRepoImpl ");

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("shopping");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            if (vishalMartEntity != null) {
                entityManager.persist(vishalMartEntity);
            } else {
                System.out.println("vishalMartEntity is pointing to null");
            }

            System.out.println("Data added successfully");

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
    public VishalMartEntity findEntityById(int id) {
        System.out.println("Running findEntityById in VishalMartRepositoryImpl");
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        VishalMartEntity vishalMartEntity = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("shopping");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            vishalMartEntity = entityManager.find(VishalMartEntity.class, id);

            entityTransaction.commit();

            if (vishalMartEntity != null) {
                return vishalMartEntity;
            }

        } catch (Exception e) {

            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }

        } finally {
            entityManager.close();
        }

        return null;
    }

    @Override
    public boolean updateLocationById(int id, String location) {

        System.out.println("Running updateLocationById in VishalMartRepositoryImpl");
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        VishalMartEntity vishalMartEntity = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("shopping");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            vishalMartEntity = entityManager.find(VishalMartEntity.class, id);

            if (vishalMartEntity != null) {
                vishalMartEntity.setLocation(location);
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
    public boolean deleteEntityByID(int id) {

        System.out.println("Running deleteEntityByID in VishalMartRepositoryImpl");
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        VishalMartEntity vishalMartEntity = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("shopping");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            vishalMartEntity = entityManager.find(VishalMartEntity.class, id);

            if (vishalMartEntity != null) {
                entityManager.remove(vishalMartEntity);
            }

            entityTransaction.commit();

            return true;

        } catch (Exception e) {

            if (entityTransaction.isActive()){
                entityTransaction.rollback();
            }

        } finally {
            entityManager.close();
        }
        return false;
    }
}
