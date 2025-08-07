package com.xworkz.adhar.service;

import com.xworkz.adhar.entity.AdharEntity;

import java.util.List;

public interface AdharEntityService {

    boolean addAll(List<AdharEntity> entityList);

    AdharEntity findByName(String name);
}
