package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.DoctorRegisterEntity;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@ToString
@Slf4j
@Repository
public class DoctorRepositoryImpl implements DoctorRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory;

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
    public List<DoctorRegisterEntity> getAllDoctors() {

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<DoctorRegisterEntity> doctorRegisterEntities = null;
        try {

            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            doctorRegisterEntities = entityManager.createNamedQuery("getAllDoctors").getResultList();
            log.info("In repo " + doctorRegisterEntities.toString());
            entityTransaction.commit();
            if (doctorRegisterEntities != null && !doctorRegisterEntities.isEmpty()) {
                return doctorRegisterEntities;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        return Collections.emptyList();
    }

    @Override
    public boolean updateDoctorDetails(DoctorRegisterEntity doctorRegisterEntity) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(doctorRegisterEntity);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return false;
    }

    @Override
    public boolean deleteDoctorByEmail(String email) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        DoctorRegisterEntity fetchedDoctorEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("getDoctorEntityByEmail");
            query.setParameter("email", email);

            fetchedDoctorEntity = (DoctorRegisterEntity) query.getSingleResult();

            if (fetchedDoctorEntity != null) {
                entityManager.remove(fetchedDoctorEntity);
                entityTransaction.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return false;
    }

    @Override
    public DoctorRegisterEntity getDoctorByEmail(String email) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        DoctorRegisterEntity fetchedDoctorEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("getDoctorEntityByEmail");
            query.setParameter("email", email);

            fetchedDoctorEntity = (DoctorRegisterEntity) query.getSingleResult();
            entityTransaction.commit();
            if (fetchedDoctorEntity != null) {
                return fetchedDoctorEntity;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public DoctorRegisterEntity getDoctorById(int id) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        DoctorRegisterEntity doctorRegisterEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("getDoctorById");
            query.setParameter("id", id);
            doctorRegisterEntity = (DoctorRegisterEntity) query.getSingleResult();
            entityTransaction.commit();
            return doctorRegisterEntity;

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
