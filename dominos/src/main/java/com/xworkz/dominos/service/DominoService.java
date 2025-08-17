package com.xworkz.dominos.service;

import com.xworkz.dominos.dto.DominosDto;
import com.xworkz.dominos.entity.DominosEntity;

import java.util.List;

public interface DominoService {

    boolean saveData(DominosDto dominosDto);

    List<DominosEntity> fetchDetails();

    DominosDto getById(int id);

    boolean updateById(int id,DominosDto dto);

    boolean deleteById(int id);

    List<DominosEntity> getDomainList(String domain);
}
