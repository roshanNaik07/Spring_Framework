package com.xworkz.student.runner;

import com.xworkz.student.entity.StudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentRunner {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try{
            StudentEntity studentEntity = entityManager.find(StudentEntity.class,2);

            if (studentEntity!=null){
                studentEntity.setName("Prajwal");
            }
            StudentEntity studentEntity1 = entityManager.find(StudentEntity.class,3);
            entityManager.remove(studentEntity1);
            entityTransaction.commit();
        }
        catch (Exception e){
            System.out.println("didn't get the connection");
        }
        finally {
            entityManagerFactory.close();
        }
    }

}
