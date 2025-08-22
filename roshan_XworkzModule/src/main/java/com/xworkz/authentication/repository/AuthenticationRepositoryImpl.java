package com.xworkz.authentication.repository;

import com.xworkz.authentication.entity.AuthenticationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class AuthenticationRepositoryImpl implements AuthenticationRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public boolean saveSignUpDetails(AuthenticationEntity authenticationEntity) {

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {

            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            entityManager.persist(authenticationEntity);

            entityTransaction.commit();

            System.out.println("Saved");

            return true;

        } catch (Exception e) {

            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            e.printStackTrace();

        } finally {
            entityManager.close();
        }

        return false;
    }

    @Override
    public AuthenticationEntity signIn(String username) {

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        AuthenticationEntity entity;
        try {

            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("getByUsernameAndPassword");
            query.setParameter("username", username);
            try {
                entity = (AuthenticationEntity) query.getSingleResult();
            }catch (NoResultException nrp){
                System.out.println("Entity is null for the Query");
                return null;
            }
            System.out.println("Details fetched");
            entityTransaction.commit();
            return entity;

        } catch (Exception e) {

            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            e.printStackTrace();

        } finally {
            entityManager.close();
        }

        return null;
    }

    @Override
    public Boolean forgotPassword(String email, String password, String confirmPassword) {

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        AuthenticationEntity entity = new AuthenticationEntity();
        try {

            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("getEntityByEmail");
            query.setParameter("email", email);

            try {
                entity = (AuthenticationEntity) query.getSingleResult();
            }catch (Exception e){
                return false;
            }

            System.out.println("Entity found");
            entity.setPassword(password);
            entity.setConfirmPassword(confirmPassword);
            entityTransaction.commit();
            return true;

        } catch (Exception e) {

            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            e.printStackTrace();

        } finally {
            entityManager.close();
        }

        return false;
    }

    @Override
    public AuthenticationEntity updateUserData(AuthenticationEntity authenticationEntity) {
        System.out.println("Running updateUserData in AuthenticationRepositoryImpl");
        System.out.println(authenticationEntity);

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        AuthenticationEntity authenticationEntity1 = new AuthenticationEntity();
        try {

            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("getEntityByName");
            query.setParameter("name", authenticationEntity.getName());
            authenticationEntity1 = (AuthenticationEntity) query.getSingleResult();
            System.out.println("Details fetched");

            authenticationEntity1.setPhoneNo(authenticationEntity.getPhoneNo());
            authenticationEntity1.setEmail(authenticationEntity.getEmail());
            authenticationEntity1.setAge(authenticationEntity.getAge());
            authenticationEntity1.setAddress(authenticationEntity.getAddress());

            entityManager.merge(authenticationEntity1);
            entityTransaction.commit();
            return authenticationEntity1;

        } catch (Exception e) {

            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            e.printStackTrace();

        } finally {
            entityManager.close();
        }

        return null;
    }

}
