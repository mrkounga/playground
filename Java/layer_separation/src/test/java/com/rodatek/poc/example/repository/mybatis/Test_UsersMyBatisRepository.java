package com.rodatek.poc.example.repository.mybatis;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rodatek.common.repository.mybatis.BaseMyBatisRepository;
import com.rodatek.example.repository.mybatiscommon.Test_AbstractMyBatisRepository;

import lombok.extern.log4j.Log4j2;

/**
 * @author koungam
 *
 */
@DisplayName("Test - User MyBatis Repository")
@Log4j2
public class Test_UsersMyBatisRepository extends Test_AbstractMyBatisRepository<UserEntity> {

	@Autowired
	UserMyBatisRepository repository;

	@Override
	protected BaseMyBatisRepository<UserEntity> getRepository() {
		return repository;
	}

	@Override
	protected UserEntity givenEntity() {
		UserEntity myUser = UserEntity.builder().email("kounga@gmail.com").firstname("Michel")
				.username("TheKoung").build();
		return myUser;
	}

	protected List<UserEntity> createListEntities() {
		List<UserEntity> entities = new ArrayList<UserEntity>();
		for (int i = 0; i < 10; i++) {
			entities.add(givenEntity());
		}
		return entities;
	}

	
	@Override
	@Test
	@DisplayName("Test - Update Entities")
	protected void testUpdate() {
		//arrange
		long entityId=4L;
		UserEntity userFound= getRepository().findById(entityId).get();
		UserEntity userToUpdate = UserEntity.builder()
				.id(userFound.getId())
				.email("myNewEmail@fake.com")
				.firstname(userFound.getFirstname())
				.username(userFound.getUsername())
				.build();
		//Act
		boolean isSaved=getRepository().update(userToUpdate);
		UserEntity updatedUser=repository.findByEmail("myNewEmail@fake.com").get();
		
		//Assert
		assertThat(updatedUser.getEmail()).isNotEqualTo(userFound.getEmail());
		
	}
	
	@Test
	@DisplayName("ID value")
	void chechId() {
		for(int i=0;i<10;i++) {
			UserEntity myUser = UserEntity.builder().email(i+"kounga@gmail.com").firstname("Michel")
					.username("TheKoung").build();
			int saved=getRepository().save(myUser);
			log.info(">>>Saved number id : "+saved);
			}
		getRepository().findAll().forEach(e->log.info("entity retrived : "+e));
	}

}
