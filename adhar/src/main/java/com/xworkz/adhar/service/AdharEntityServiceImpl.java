package com.xworkz.adhar.service;

import com.xworkz.adhar.entity.AdharEntity;
import com.xworkz.adhar.repository.AdharRepository;
import com.xworkz.adhar.repository.AdharRepositoryImpl;

import java.util.Collections;
import java.util.List;

public class AdharEntityServiceImpl implements AdharEntityService{
    AdharRepository adharRepository = new AdharRepositoryImpl();

    @Override
    public boolean addAll(List<AdharEntity> entityList) {

        if (entityList != null){
            AdharRepository adharRepository = new AdharRepositoryImpl();
            adharRepository.addAll(entityList);
            return true;
        }

        return false;
    }

    @Override
    public AdharEntity findByName(String name) {

        if (name != null){
            return adharRepository.findByName(name);
        }
        return null;
    }

    @Override
    public AdharEntity findBYNameAndAge(String name, int age) {

        if (name!= null && age !=0){
            return adharRepository.findByNameAndAge(name,age);
        }

        return null;
    }

    @Override
    public List<AdharEntity> getByAgeAbove(int age) {

        if (age != 0){
            return adharRepository.getByAgeAbove(age);
        }
        return Collections.emptyList();
    }

    @Override
    public List<AdharEntity> getAgeBetween(int age1, int age2) {

        if(age1 !=0 && age2 !=0 ){
            return adharRepository.getAgeBetween(age1,age2);
        }

        return Collections.emptyList();
    }

    @Override
    public String getNameByEmail(String email) {

        return new AdharRepositoryImpl().getNameByEmail(email);
    }

    @Override
    public AdharEntity getPhoneNumberAndNameByEmail(String email) {
        return new AdharRepositoryImpl().getPhoneAndNameByEmail(email);
    }

    @Override
    public AdharEntity getEntityByAgeAndPhoneNo(int age, long phoneNo) {
        return adharRepository.getEntityByAgeAndPhoneNo(age,phoneNo);
    }

    @Override
    public List<AdharEntity> getListOfEntityByAge(int age) {
        System.out.println("Running getListOfEntityByAge");
        return adharRepository.getListOfEntityByAge(age);
    }

    @Override
    public List<AdharEntity> getNameAndPhByAge(int age) {
        return adharRepository.getNameAndPhByAge(age);
    }


}
