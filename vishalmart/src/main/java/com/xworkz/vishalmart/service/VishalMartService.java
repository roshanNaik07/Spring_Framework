package com.xworkz.vishalmart.service;

import com.xworkz.vishalmart.entity.VishalMartEntity;

public interface VishalMartService {

    VishalMartEntity save(VishalMartEntity vishalMartEntity);

    VishalMartEntity findEntityById(int id);

    boolean updateLocationById(int id ,String location);

    boolean deleteEntityById(int id);

}
