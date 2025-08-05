package com.xworkz.vishalmart.repository;

import com.xworkz.vishalmart.entity.VishalMartEntity;

public interface VishalMartRepository {

    VishalMartEntity saveData(VishalMartEntity vishalMartEntity);

    VishalMartEntity findEntityById(int id);

    boolean updateLocationById(int id , String location);

    boolean deleteEntityByID(int id);
}
