package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.DoctorRegisterEntity;
import com.xworkz.hospital.entity.DoctorTimeSlotEntity;
import com.xworkz.hospital.entity.SlotTimeEntity;
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
public class SlotRepositoryImpl implements SlotRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    public SlotRepositoryImpl() {
        log.info("Running SlotRepositoryImpl");
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
}
