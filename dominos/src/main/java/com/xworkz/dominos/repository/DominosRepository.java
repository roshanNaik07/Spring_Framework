package com.xworkz.dominos.repository;

import com.xworkz.dominos.entity.DominosEntity;

import javax.persistence.Entity;
import java.util.List;

public interface DominosRepository {

    boolean saveData(DominosEntity entity);

    List<DominosEntity> fetchDetails();

    DominosEntity getById(int id);
}
