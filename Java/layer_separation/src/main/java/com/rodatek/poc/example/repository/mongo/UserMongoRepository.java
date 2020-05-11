package com.rodatek.poc.example.repository.mongo;

import org.springframework.stereotype.Repository;

import com.rodatek.common.repository.mongo.BaseMongoRepository;




@Repository
public interface UserMongoRepository extends BaseMongoRepository<UserMongoEntity> {

	
}
