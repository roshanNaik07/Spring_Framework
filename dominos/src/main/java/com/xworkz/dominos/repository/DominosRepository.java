package com.xworkz.dominos.repository;

import com.xworkz.dominos.entity.DominosEntity;

import javax.persistence.Entity;
import java.util.List;

public interface DominosRepository {

    boolean saveData(DominosEntity entity);

    List<DominosEntity> fetchDetails();

    DominosEntity getById(int id);

    boolean updateById(int id , DominosEntity dominosEntity);

    boolean deleteById(int id );

    List<DominosEntity> getDomainList(String domain);

    List<String> getNamesAbovePrice(int price);
}
