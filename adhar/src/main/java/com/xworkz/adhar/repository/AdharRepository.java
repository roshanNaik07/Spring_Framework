package com.xworkz.adhar.repository;

import com.xworkz.adhar.entity.AdharEntity;

import java.util.List;

public interface AdharRepository {

    boolean addAll(List<AdharEntity> list);

    AdharEntity findByName(String name);

    AdharEntity findByNameAndAge(String name, int age);

    List<AdharEntity> getByAgeAbove(int age);

    List<AdharEntity> getAgeBetween(int age1 , int age2);

    String getNameByEmail(String email);

    AdharEntity getPhoneAndNameByEmail(String email);

    AdharEntity getEntityByAgeAndPhoneNo(int age , long phoneNo);

    List<AdharEntity> getListOfEntityByAge(int age);

    List<AdharEntity> getNameAndPhByAge(int age);
}
