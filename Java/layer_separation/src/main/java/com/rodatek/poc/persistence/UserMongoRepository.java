package com.rodatek.poc.persistence;

import org.springframework.stereotype.Repository;

import com.rodatek.common.persistence.BaseMongoRepository;
//Will be an interface this is just for testing
import com.rodatek.poc.model.UserMongoEntity;

@Repository
public interface UserMongoRepository extends BaseMongoRepository<UserMongoEntity> {

	
	

}
