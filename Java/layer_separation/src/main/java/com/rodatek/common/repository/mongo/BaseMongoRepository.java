package com.rodatek.common.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.rodatek.common.model.MongoEntity;
import com.rodatek.common.repository.BaseRepository;



@NoRepositoryBean
public interface BaseMongoRepository<E extends MongoEntity> extends MongoRepository<E,String>, BaseRepository<E>{  

}
