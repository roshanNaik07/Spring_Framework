package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.DoctorRegisterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class DoctorRepositoryImpl implements DoctorRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory;

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
            entityTransaction.commit();
            if (doctorRegisterEntities != null && !doctorRegisterEntities.isEmpty()){
                return doctorRegisterEntities;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            entityManager.close();
        }

        return Collections.emptyList();
    }

    @Override
    public boolean updateDoctorDetails(DoctorRegisterEntity doctorRegisterEntity) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        DoctorRegisterEntity fetchedDoctorEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("getDoctorEntityByEmail");
            query.setParameter("email", doctorRegisterEntity.getEmail());

            fetchedDoctorEntity = (DoctorRegisterEntity) query.getSingleResult();

            fetchedDoctorEntity.setName(doctorRegisterEntity.getName());
            fetchedDoctorEntity.setPhoneNumber(doctorRegisterEntity.getPhoneNumber());
            fetchedDoctorEntity.setSpecialization(doctorRegisterEntity.getSpecialization());
            fetchedDoctorEntity.setExperience(doctorRegisterEntity.getExperience());
            fetchedDoctorEntity.setQualification(doctorRegisterEntity.getQualification());
            fetchedDoctorEntity.setImageName(doctorRegisterEntity.getImageName());

            entityManager.merge(fetchedDoctorEntity);
            entityTransaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
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
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return false;
    }
}
