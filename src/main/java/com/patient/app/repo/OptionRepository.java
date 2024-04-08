package com.patient.app.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.patient.app.model.Option;

public interface OptionRepository extends MongoRepository <Option, String>{

}
