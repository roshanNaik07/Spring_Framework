package com.xworkz.hospital.repository;

import com.xworkz.hospital.dto.SlotTimeDTO;
import com.xworkz.hospital.entity.DoctorRegisterEntity;
import com.xworkz.hospital.entity.SlotTimeEntity;
import com.xworkz.hospital.entity.SpecializationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

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
            query.setParameter("email", email);
            System.out.println("Query executed");
            adminEmail = (String) query.getSingleResult();
            if (adminEmail.isEmpty()) {
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
            query.setParameter("email", email);
            System.out.println("Query executed");
            adminEmail = (String) query.getSingleResult();
            if (adminEmail.isEmpty()) {
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

        System.out.println("In repo" + doctorRegisterEntity);
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {

            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(doctorRegisterEntity);

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
    public boolean saveSlotTime(SlotTimeEntity slotTimeEntity) {

        System.out.println("Running saveSlotTime " + slotTimeEntity);
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {

            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(slotTimeEntity);

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
    public List<DoctorRegisterEntity> getDoctorEntityBySpecialization(String specialization) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<DoctorRegisterEntity> doctorRegisterEntities= null;
        try {

            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Query query = entityManager.createNamedQuery("getDoctorEntitySpecialization");
            query.setParameter("specialization", specialization);
            doctorRegisterEntities = query.getResultList();
            if (doctorRegisterEntities.isEmpty()) {
                return Collections.emptyList();
            }
            entityTransaction.commit();

        } catch (Exception e) {

            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            e.printStackTrace();

        } finally {
            entityManager.close();
        }

        return doctorRegisterEntities;
    }

    @Override
    public void addSpecialization(SpecializationEntity specializationEntity) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(specializationEntity);

            transaction.commit();
            System.out.println("Specialization saved successfully");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<String> getAllSpecializations() {
            EntityManager entityManager = null;
            EntityTransaction entityTransaction = null;
            List<String> specializationList ;
            try {

                entityManager = entityManagerFactory.createEntityManager();
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();

                Query query = entityManager.createNamedQuery("getAllSpecializations");
                specializationList = query.getResultList();
                if (specializationList.isEmpty()) {
                    return Collections.emptyList();
                }
                entityTransaction.commit();
                return specializationList;

            } catch (Exception e) {

                if (entityTransaction.isActive()) {
                    entityTransaction.rollback();
                }
                e.printStackTrace();

            } finally {
                entityManager.close();
            }
        return Collections.emptyList();
    }

    @Override
    public List<SlotTimeEntity> getAllSlotsBySpecialization(String Specialization) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<SlotTimeEntity> slotTimeEntities;
        try {

            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Query query = entityManager.createNamedQuery("getAllSlotsBySpecialization");
            query.setParameter("specialization", Specialization);
            slotTimeEntities = query.getResultList();
            if (slotTimeEntities.isEmpty()) {
                return Collections.emptyList();
            }
            entityTransaction.commit();

            for (SlotTimeEntity entity : slotTimeEntities) {
                System.out.println(entity);
            }

            return slotTimeEntities;

        } catch (Exception e) {

            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            e.printStackTrace();

        } finally {
            entityManager.close();
        }
        return Collections.emptyList();
    }

    @Override
    public boolean saveDoctorSlots(String email, String slots) {

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        try {

            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Query query = entityManager.createNamedQuery("updateDoctorSlots");
            query.setParameter("slotTimings", slots);
            query.setParameter("email", email);
            int updatedCount = query.executeUpdate();
            if (updatedCount > 0) {
                System.out.println("Doctor slots updated successfully for email: " + email);
                entityTransaction.commit();
                return true;
            } else {
                System.out.println("No doctor found with email: " + email);
                entityTransaction.rollback();
                return false;
            }

        } catch (Exception e) {

            assert entityTransaction != null;
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            e.printStackTrace();

        } finally {
            entityManager.close();
        }
        return false;
    }
}
