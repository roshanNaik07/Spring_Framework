package com.xworkz.travel.service;

import com.xworkz.travel.dto.StudentDto;
import com.xworkz.travel.entity.StudentEntity;
import com.xworkz.travel.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    TravelRepository travelRepository;

    @Override
    public boolean saveStudentData(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(studentDto.getFirstName());
        studentEntity.setMiddleName(studentDto.getMiddleName());
        studentEntity.setLastName(studentDto.getLastName());
        studentEntity.setAge(studentDto.getAge());
        studentEntity.setEmail(studentDto.getEmail());
        studentEntity.setUsn(studentDto.getUsn());
        studentEntity.setPhoneNo(studentDto.getPhoneNo());

        return travelRepository.saveStudentData(studentEntity);
    }
}
