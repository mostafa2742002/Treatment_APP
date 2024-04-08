package com.patient.app.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.patient.app.model.Program;

public interface ProgramRepository extends MongoRepository<Program, String> {

}
