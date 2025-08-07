package com.xworkz.adhar.service;

import com.xworkz.adhar.entity.AdharEntity;
import com.xworkz.adhar.repository.AdharRepository;
import com.xworkz.adhar.repository.AdharRepositoryImpl;

import java.util.List;

public class AdharEntityServiceImpl implements AdharEntityService{
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
            AdharRepository adharRepository = new AdharRepositoryImpl();
            return adharRepository.findByName(name);
        }
        return null;
    }
}
