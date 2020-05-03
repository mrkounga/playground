package com.rodatek.example.repository;

import org.springframework.stereotype.Repository;

import com.rodatek.common.repository.mongo.BaseMongoRepository;
import com.rodatek.example.model.UserMongoEntity;

@Repository
public interface UserMongoRepository extends BaseMongoRepository<UserMongoEntity> {

	
	

}
