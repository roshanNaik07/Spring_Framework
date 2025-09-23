package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.DoctorRegisterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
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
}
