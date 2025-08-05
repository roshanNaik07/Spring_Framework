package com.xworkz.dmart.service;

import com.xworkz.dmart.entity.DmartEntity;
import com.xworkz.dmart.repository.DmartRepository;
import com.xworkz.dmart.repository.DmartRepositoryImpl;

public class DmartServiceImpl implements DmartService {
    @Override
    public DmartEntity save(DmartEntity dmartEntity) {
        System.out.println("Running service impl class");

        DmartRepository dmartRepository = new DmartRepositoryImpl();
        return dmartRepository.saveData(dmartEntity);
    }

    @Override
    public DmartEntity getEntityById(int id) {

        System.out.println("Running getProductById() in DmartServiceImpl");
        DmartRepository dmartRepository = new DmartRepositoryImpl();
        return dmartRepository.getEntityById(id);
    }

    @Override
    public boolean updateProductById(int id, String product) {

        System.out.println("Running updateProductById in DmartServiceImpl");

        if (id != 0){
            DmartRepository dmartRepository = new DmartRepositoryImpl();
            return dmartRepository.updateProductById(id,product);
        }
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        System.out.println("Running deleteEntityById in DmartServiceImpl");
        if (id != 0 ){
            DmartRepository dmartRepository = new DmartRepositoryImpl();
            return dmartRepository.deleteEntityById(id);
        }
        return false;
    }
}
