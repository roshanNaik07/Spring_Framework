package com.xworkz.adhar.service;

import com.xworkz.adhar.entity.AdharEntity;

import java.util.List;

public interface AdharEntityService {

    boolean addAll(List<AdharEntity> entityList);

    AdharEntity findByName(String name);

    AdharEntity findBYNameAndAge(String name , int age);

    List<AdharEntity> getByAgeAbove(int age);

    List<AdharEntity> getAgeBetween(int age1 , int age2);

    String getNameByEmail(String email);

    AdharEntity getPhoneNumberAndNameByEmail(String email);

    AdharEntity getEntityByAgeAndPhoneNo(int age , long phoneNo);

    List<AdharEntity> getListOfEntityByAge (int age );

    List<AdharEntity> getNameAndPhByAge(int age);
}
