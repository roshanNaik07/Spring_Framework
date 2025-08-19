package com.xworkz.travel.repository;

import com.xworkz.travel.entity.BgmiEntity;
import com.xworkz.travel.entity.StudentEntity;
import com.xworkz.travel.entity.TrainingEntity;

public interface TravelRepository {

    boolean saveStudentData(StudentEntity studentEntity);

    boolean saveTrainingData(TrainingEntity trainingEntity);

    boolean saveBgmiData(BgmiEntity bgmiEntity);
}
