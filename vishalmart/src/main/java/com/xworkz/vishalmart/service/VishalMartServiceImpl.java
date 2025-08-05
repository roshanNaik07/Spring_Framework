package com.xworkz.vishalmart.service;

import com.xworkz.vishalmart.entity.VishalMartEntity;
import com.xworkz.vishalmart.repository.VishalMartRepository;
import com.xworkz.vishalmart.repository.VishalMartRepositoryImpl;

public class VishalMartServiceImpl implements VishalMartService {

    @Override
    public VishalMartEntity save(VishalMartEntity vishalMartEntity) {

        System.out.println("Running VishalMartServiceImpl");

        VishalMartRepository vishalMartRepository = new VishalMartRepositoryImpl();
        return vishalMartRepository.saveData(vishalMartEntity);
    }

    @Override
    public VishalMartEntity findEntityById(int id) {

        System.out.println("Running findEntityById in VishalMartServiceImpl");
        if (id != 0) {

            VishalMartRepository vishalMartRepository = new VishalMartRepositoryImpl();
            return vishalMartRepository.findEntityById(id);
        }
        return null;
    }

    @Override
    public boolean updateLocationById(int id, String location) {

        System.out.println("Running updateLocationById in VishalMartServiceImpl");

        if (id != 0){
            VishalMartRepository vishalMartRepository = new VishalMartRepositoryImpl();
            return vishalMartRepository.updateLocationById(id , location);
        }
            return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        System.out.println("Running deleteEntityById in VishalMartServiceImpl");
        if (id != 0){
            VishalMartRepository vishalMartRepository = new VishalMartRepositoryImpl();
            return vishalMartRepository.deleteEntityByID(id);
        }

        return false;
    }
}
