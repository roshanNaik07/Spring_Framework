package com.xworkz.kfi.runner;

import com.xworkz.kfi.entity.FilmEntity;
import com.xworkz.kfi.entity.KFIEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class KfiRunner {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("KFI");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        List<KFIEntity> list = new ArrayList<>();
        list.add(new KFIEntity(1,"Yash","Radhika",78,35,5));
        list.add(new KFIEntity(2, "Darshan", "Vijaya", 85, 42, 4));
        list.add(new KFIEntity(3, "Puneeth", "Ashwini", 90, 50, 5));
        list.add(new KFIEntity(4, "Upendra", "Priyanka", 70, 30, 3));
        list.add(new KFIEntity(5, "Rakshit", "Rashmika", 82, 38, 4));

        for (KFIEntity ref : list){
            entityManager.persist(ref);
        }

        List<FilmEntity> filmEntityList = new ArrayList<>();
        filmEntityList.add(new FilmEntity(1,"KGF","yash","Srinidhi","Neel",4));
        filmEntityList.add(new FilmEntity(2, "Kantara", "Rishab", "Sapthami", "Rishab", 5));
        filmEntityList.add(new FilmEntity(3, "Ugramm", "Sri Murali", "Haripriya", "Prashanth Neel", 4));
        filmEntityList.add(new FilmEntity(4, "Charlie 777", "Rakshit", "Sangeetha", "Kiranraj K", 5));
        filmEntityList.add(new FilmEntity(5, "Yuvarathnaa", "Puneeth", "Sayyeshaa", "Santhosh Ananddram", 4));

        for (FilmEntity ref : filmEntityList){
            entityManager.persist(ref);
        }

        entityTransaction.commit();
        FilmEntity filmEntity = entityManager.find(FilmEntity.class, 3);
        System.out.println(filmEntity);

        KFIEntity kfiEntity = entityManager.find(KFIEntity.class, 5);
        System.out.println(kfiEntity);

        entityManager.close();
        entityManagerFactory.close();
    }

}
