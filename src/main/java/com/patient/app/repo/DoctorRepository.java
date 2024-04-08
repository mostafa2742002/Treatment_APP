package com.patient.app.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.patient.app.model.Doctor;

public interface DoctorRepository extends MongoRepository <Doctor, String>{

}
