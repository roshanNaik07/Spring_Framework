package com.xworkz.hospital.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Collections;
import java.util.List;

@Repository
@Slf4j
public class PatientRepositoryImpl implements PatientRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public List<String> getAllBloodGroups() {
        log.info("Running getAllBloodGroups in PatientRepositoryImpl");
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<String> bloodGroups = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            bloodGroups = entityManager.createNamedQuery("getAllBloodGroups").getResultList();
            entityTransaction.commit();
            if (bloodGroups != null && !bloodGroups.isEmpty()) {
                return bloodGroups;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return Collections.emptyList();
    }
}
