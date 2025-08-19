package com.xworkz.travel.service;

import com.xworkz.travel.dto.BgmiDto;
import com.xworkz.travel.dto.StudentDto;
import com.xworkz.travel.dto.TrainingDto;
import com.xworkz.travel.entity.BgmiEntity;
import com.xworkz.travel.entity.StudentEntity;
import com.xworkz.travel.entity.TrainingEntity;
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

    @Override
    public boolean saveTrainingData(TrainingDto trainingDto) {
        TrainingEntity trainingEntity = new TrainingEntity();
        trainingEntity.setTrainingName(trainingDto.getTrainingName());
        trainingEntity.setLocation(trainingDto.getLocation());
        trainingEntity.setCourseName(trainingDto.getCourseName());
        trainingEntity.setTrainerName(trainingDto.getTrainerName());
        trainingEntity.setTrainerExperience(trainingDto.getTrainerExperience());
        trainingEntity.setEmail(trainingEntity.getEmail());
        trainingEntity.setPhoneNo(trainingEntity.getPhoneNo());
        return travelRepository.saveTrainingData(trainingEntity);
    }

    @Override
    public boolean saveBgmiData(BgmiDto bgmiDto) {
        System.out.println("Running saveBgmiData in TravelServiceImpl ");
        BgmiEntity bgmiEntity = new BgmiEntity();
        bgmiEntity.setGameName(bgmiDto.getGameName());
        bgmiEntity.setFounder(bgmiDto.getFounder());
        bgmiEntity.setPlayerName(bgmiDto.getPlayerName());
        bgmiEntity.setEmail(bgmiDto.getEmail());
        bgmiEntity.setGunName(bgmiDto.getGunName());
        bgmiEntity.setAge(bgmiDto.getAge());

        return travelRepository.saveBgmiData(bgmiEntity);
    }

}
