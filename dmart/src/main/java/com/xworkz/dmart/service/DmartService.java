package com.xworkz.dmart.service;

import com.xworkz.dmart.entity.DmartEntity;

public interface DmartService {

    DmartEntity save(DmartEntity dmartEntity);

    DmartEntity getEntityById(int id);

    boolean updateProductById(int id , String product);

    boolean deleteEntityById(int id);
}
