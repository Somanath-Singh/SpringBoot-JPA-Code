package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Tourist;

public interface ITuristRepo extends MongoRepository<Tourist, String> {

}
