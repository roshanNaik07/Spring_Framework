package com.xworkz.dmart.repository;

import com.xworkz.dmart.entity.DmartEntity;

public interface DmartRepository {

    DmartEntity saveData(DmartEntity dmartEntity);

    DmartEntity getEntityById(int id);

    boolean updateProductById(int id , String product);

    boolean deleteEntityById(int id);
}
