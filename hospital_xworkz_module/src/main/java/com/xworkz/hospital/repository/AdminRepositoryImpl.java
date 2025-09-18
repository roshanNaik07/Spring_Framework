package com.xworkz.hospital.repository;

import com.xworkz.hospital.dto.SlotTimeDTO;
import com.xworkz.hospital.entity.DoctorRegisterEntity;
import com.xworkz.hospital.entity.SlotTimeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Repository
public class AdminRepositoryImpl implements AdminRepository{

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public String sendOTP(String email) {

        System.out.println("Running sendOTP in AuthenticationRepositoryImpl");
        System.out.println(email);

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        String adminEmail;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("getAdminEmail");
            query.setParameter("email",email);
            System.out.println("Query executed");
            adminEmail = (String) query.getSingleResult();
            if (adminEmail.isEmpty()){
                return null;
            }
            entityTransaction.commit();
            return adminEmail;
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
    public boolean checkEmail(String email) {
        System.out.println("Running checkEmail in AuthenticationRepositoryImpl");
        System.out.println(email);

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        String adminEmail;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("getAdminEmail");
            query.setParameter("email",email);
            System.out.println("Query executed");
            adminEmail = (String) query.getSingleResult();
            if (adminEmail.isEmpty()){
                return false;
            }
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
    public boolean registerDoctor(DoctorRegisterEntity doctorRegisterEntity) {

        System.out.println("In repo"+doctorRegisterEntity);
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {

            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(doctorRegisterEntity);

            entityTransaction.commit();
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
    public boolean saveSlotTime(SlotTimeEntity slotTimeEntity) {

        System.out.println("Running saveSlotTime "+slotTimeEntity);
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {

            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(slotTimeEntity);

            entityTransaction.commit();
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


}
