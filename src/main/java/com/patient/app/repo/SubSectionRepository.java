package com.patient.app.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.patient.app.model.SubSection;

public interface SubSectionRepository extends MongoRepository <SubSection, String>{

}
