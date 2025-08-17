package com.xworkz.dominos.service;

import com.xworkz.dominos.dto.DominosDto;
import com.xworkz.dominos.entity.DominosEntity;
import com.xworkz.dominos.repository.DominosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DominosServiceImpl implements DominoService{

    @Autowired
    DominosRepository dominosRepository;

    @Override
    public boolean saveData(DominosDto dominosDto) {
        System.out.println("Running saveData in DominosServiceImpl ");
        DominosEntity entity = new DominosEntity();
        entity.setName(dominosDto.getName());
        entity.setEmail(dominosDto.getEmail());
        entity.setPhoneNo(dominosDto.getPhoneNo());
        entity.setPrice(dominosDto.getPrice());
        return dominosRepository.saveData(entity);
    }

    @Override
    public List<DominosEntity> fetchDetails() {
        System.out.println("Running fetchDetails in DominosServiceImpl ");
        return dominosRepository.fetchDetails();
    }

    @Override
    public DominosDto getById(int id) {
        System.out.println("Running getById in DominosServiceImpl");

        DominosEntity entity = dominosRepository.getById(id);
        if(entity != null){
            DominosDto dto = new DominosDto();
            dto.setName(entity.getName());
            dto.setEmail(entity.getEmail());
            dto.setPhoneNo(entity.getPhoneNo());
            dto.setPrice(entity.getPrice());
            return dto;
        }
        return null;
    }

    @Override
    public boolean updateById(int id ,DominosDto dto) {
        System.out.println("Running updateId in DominosServiceImpl");
        DominosEntity dominosEntity = new DominosEntity();
        dominosEntity.setName(dto.getName());
        dominosEntity.setEmail(dto.getEmail());
        dominosEntity.setPhoneNo(dto.getPhoneNo());
        dominosEntity.setPrice(dto.getPrice());

        return dominosRepository.updateById(id,dominosEntity);
    }

    @Override
    public boolean deleteById(int id) {
        System.out.println("Running deleteById in DominosServiceImpl");
        return dominosRepository.deleteById(id);
    }

    @Override
    public List<DominosEntity> getDomainList(String domain) {

        return dominosRepository.getDomainList(domain);
    }

    @Override
    public List<String> getNameAbovePrice(int price) {

        return dominosRepository.getNamesAbovePrice(price);
    }

}
