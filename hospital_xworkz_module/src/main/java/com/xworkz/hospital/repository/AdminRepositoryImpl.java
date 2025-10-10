package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.DoctorRegisterEntity;
import com.xworkz.hospital.entity.DoctorTimeSlotEntity;
import com.xworkz.hospital.entity.SlotTimeEntity;
import com.xworkz.hospital.entity.SpecializationEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
@Slf4j
public class AdminRepositoryImpl implements AdminRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public String sendOTP(String email) {

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        String adminEmail;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("getAdminEmail");
            query.setParameter("email", email);
            log.info("Query executed");
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
        log.info("Running checkEmail in repo "+email);
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        String adminEmail;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("getAdminEmail");
            query.setParameter("email", email);
            log.info("Query executed");
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

        log.info("In repo" + doctorRegisterEntity);
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

        log.info("Running saveSlotTime " + slotTimeEntity);
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
        List<DoctorRegisterEntity> doctorRegisterEntities = null;
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
            log.info("Specialization saved successfully");
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
        List<String> specializationList;
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
                log.info(String.valueOf(entity));
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

            DoctorRegisterEntity doctorRegisterEntity = entityManager
                    .createNamedQuery("getDoctorEntityByEmail", DoctorRegisterEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();

            if (doctorRegisterEntity == null) {
                return false;
            }

            DoctorTimeSlotEntity doctorTimeSlotEntity = new DoctorTimeSlotEntity();
            doctorTimeSlotEntity.setSlotTimings(slots);
            doctorTimeSlotEntity.setDoctor(doctorRegisterEntity);

            entityManager.persist(doctorTimeSlotEntity);

            entityTransaction.commit();
            return true;

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

    @Override
    public List<DoctorTimeSlotEntity> getDoctorTimeSlotEntitiesById(int id) {
        log.info("In repo getDoctorSlotsById " + id);
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<DoctorTimeSlotEntity> doctorTimeSlotEntities;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Query query = entityManager.createNamedQuery("getDoctorSlotEntitiesById");
            query.setParameter("id",id);
            doctorTimeSlotEntities = query.getResultList();
            if (doctorTimeSlotEntities.isEmpty()) {
                return Collections.emptyList();
            }
            log.info("Doctor slots found: " + doctorTimeSlotEntities);
            entityTransaction.commit();
            return doctorTimeSlotEntities;

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


}
