package com.rodatek.poc.example.repository.mybatis;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.rodatek.common.repository.mybatis.BaseMyBatisRepository;
import com.rodatek.poc.example.model.UserEntity;

import lombok.extern.log4j.Log4j2;

//This is dummy repository
@Repository
@Log4j2
public class UserMyBastisRepository  implements BaseMyBatisRepository<UserEntity>{

	@Override
	public UserEntity save(UserEntity entity) {
		log.info(">>>>>>>>>>>>>> UserMyBatisRepository -Entity : "+entity+" has been SAVED..");
		return null;
	}

	@Override
	public Optional<UserEntity> findById(Long id) {
		log.info(">>>>>>>>>>>>>> UserMyBatisRepository -Entity with id  : "+id+" has been FOUND..");
		return null;
	}

	@Override
	public void deleteById(Long id) {
		log.info(">>>>>>>>>>>>>> UserMyBatisRepository -Entity with id  : "+id+" has been DELETED..");
		
	}

	
}
