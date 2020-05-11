package com.rodatek.example.user.repository.mongo;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rodatek.common.repository.mongo.BaseMongoRepository;
import com.rodatek.example.repository.mongocommon.Test_AbtractMongoRepository;
import com.rodatek.poc.example.repository.mongo.UserMongoEntity;
import com.rodatek.poc.example.repository.mongo.UserMongoRepository;

@DisplayName("Test - User Mongo Repository")
public class Test_UserMongoRepository extends Test_AbtractMongoRepository<UserMongoEntity>{

	@Autowired private UserMongoRepository repository;
	@Override
	protected BaseMongoRepository<UserMongoEntity> getRepository() {
		return repository;
	}

	protected UserMongoEntity createEntity() {
		UserMongoEntity myUser = UserMongoEntity.builder().email("mrkounga@gmail.com").firstname("Michel").username("TheKoung").build();		
	return myUser;
	}

	
	@Override
	@Test
	@DisplayName("Test - Update Entity")
	public void testUpdate() {
		// Arrange
		UserMongoEntity createdEntity = getRepository().save(createEntity());
		UserMongoEntity userToUpdate=UserMongoEntity.builder()
				.email("myNewEmail@gmail.com")
				.id(createdEntity.getId())
				.firstname(createdEntity.getFirstname())
				.username(createdEntity.getUsername())
				.build();
		// Act
		UserMongoEntity updatedUser = getRepository().save(userToUpdate);

		// Assert
		assertThat(updatedUser.getId()).isEqualTo(createdEntity.getId());
		assertThat(updatedUser.getEmail()).isNotEqualTo("mrkounga@gmail.com");
	}

}
