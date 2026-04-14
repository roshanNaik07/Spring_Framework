package com.xworkz.hospital.repository;

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
public class SpecializationRepositoryImpl implements SpecializationRepository{

    @Autowired
    EntityManagerFactory entityManagerFactory;

    public SpecializationRepositoryImpl(){
        log.info("Running SpecializationRepositoryImpl");
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
}
