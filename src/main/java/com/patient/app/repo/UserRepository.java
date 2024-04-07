package com.patient.app.repo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.patient.app.model.User;

@Repository
public interface UserRepository  extends MongoRepository <User, String>{
    
    User findByEmail(String email);
    User findById(int id);
}
