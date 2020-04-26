package com.rodatek.common.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.rodatek.common.model.MongoEntity;

@NoRepositoryBean
public interface BaseMongoRepository<M extends MongoEntity> extends MongoRepository<M,Long>{ 
	
}
