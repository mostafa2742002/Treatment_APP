package com.patient.app.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.patient.app.model.Section;

public interface SectionRepository extends MongoRepository <Section, String>{

}
