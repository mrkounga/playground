package com.rodatek.common.persistence.mongo;

//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.rodatek.common.persistence.BaseRepository;



@NoRepositoryBean
public interface BaseMongoRepository<M extends MongoEntity> {//extends MongoRepository<M,Long>, BaseRepository<M>{ 
	
}
