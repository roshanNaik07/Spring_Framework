package com.xworkz.dmart.service;

import com.xworkz.dmart.entity.DmartEntity;
import com.xworkz.dmart.repository.DmartRepository;
import com.xworkz.dmart.repository.DmartRepositoryImpl;

public class DmartServiceImpl implements DmartService{
    @Override
    public DmartEntity save(DmartEntity dmartEntity) {
        System.out.println("Running service impl class");

        DmartRepository dmartRepository = new DmartRepositoryImpl();
        return dmartRepository.saveData(dmartEntity);
    }
}
