package com.mindex.challenge.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mindex.challenge.data.Compansation;

@Repository
public interface CompansationRepository extends MongoRepository<Compansation, String> {
    Compansation findByEmployee(String employeeId);
}
