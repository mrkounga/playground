package com.rodatek.example.user.repository.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.rodatek.poc.example.model.UserEntity;

@SpringJUnitConfig
public class Test_UserEntity  {
	
	@Test
	@DisplayName("Test - Entity Object Creation")
	void creationUserEntity() {
		
		//Act
		UserEntity userJpaEntity = UserEntity.builder()
				.email("test")
				.build();
		
		//Assert
		assertThat(userJpaEntity).isNotNull();
	}

}
