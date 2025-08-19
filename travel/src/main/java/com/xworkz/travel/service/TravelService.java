package com.xworkz.travel.service;

import com.xworkz.travel.dto.BgmiDto;
import com.xworkz.travel.dto.StudentDto;
import com.xworkz.travel.dto.TrainingDto;

public interface TravelService {

    boolean saveStudentData(StudentDto studentDto);

    boolean saveTrainingData(TrainingDto trainingDto);

    boolean saveBgmiData(BgmiDto bgmiDto);
}
