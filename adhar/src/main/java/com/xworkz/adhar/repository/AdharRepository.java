package com.xworkz.adhar.repository;

import com.xworkz.adhar.entity.AdharEntity;

import java.util.List;

public interface AdharRepository {

    boolean addAll(List<AdharEntity> list);

    AdharEntity findByName(String name);

}
