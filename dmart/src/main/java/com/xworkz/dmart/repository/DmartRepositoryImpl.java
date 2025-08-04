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
            if (entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        } finally {
            entityManagerFactory.close();
        }
        return null;
    }

}
