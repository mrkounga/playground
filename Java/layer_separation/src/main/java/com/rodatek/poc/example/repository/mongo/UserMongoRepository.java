package com.rodatek.poc.example.repository.mongo;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.rodatek.common.repository.mongo.BaseMongoRepository;
import com.rodatek.poc.example.model.UserEntity;

import lombok.extern.log4j.Log4j2;


//This is dummy repository
@Repository
@Log4j2
public class UserMongoRepository implements BaseMongoRepository<com.rodatek.poc.example.model.UserEntity> {

	@Override
	public UserEntity save(UserEntity entity) {
		log.info(">>>>>>>>>>>>>> UserMongoRepository -Entity : "+entity+" has been SAVED..");
		return null;
	}

	@Override
	public Optional<UserEntity> findById(Long id) {
		log.info(">>>>>>>>>>>>>> UserMongoRepository -Entity with id  : "+id+" has been FOUND..");
		return null;
	}

	@Override
	public void deleteById(Long id) {
		log.info(">>>>>>>>>>>>>> UserMongoRepository -Entity with id  : "+id+" has been DELETED..");
		
	}

	
	
}
