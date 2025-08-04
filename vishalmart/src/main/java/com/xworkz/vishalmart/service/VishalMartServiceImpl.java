package com.xworkz.vishalmart.service;

import com.xworkz.vishalmart.entity.VishalMartEntity;
import com.xworkz.vishalmart.repository.VishalMartRepository;
import com.xworkz.vishalmart.repository.VishalMartRepositoryImpl;

public class VishalMartServiceImpl implements VishalMartService{

    @Override
    public VishalMartEntity save(VishalMartEntity vishalMartEntity) {

        System.out.println("Running VishalMartServiceImpl");

        VishalMartRepository vishalMartRepository = new VishalMartRepositoryImpl();
        return vishalMartRepository.saveData(vishalMartEntity);
    }
}
