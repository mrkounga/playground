package com.rodatek.example.persistenceservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.rodatek.common.persistence.PersistenceDtoService;
import com.rodatek.common.persistence.config.PersitenceJpaServiceConfig;
import com.rodatek.example.businessdomain.UserDto;
import com.rodatek.example.model.impl.UserJpaEntity;

//@DataJpaTest
//@ContextConfiguration(classes = PersitenceJpaServiceConfig.class)
@SpringJUnitConfig()
@SpringBootTest
class Test_UserPersistenceService {
	
	@Autowired
	PersistenceDtoService<UserDto> persistenceService;
	
	private UserDto createNewDto() {
		UserDto userDto=UserDto.builder()
				.email("mrkounga@gmail.com")
				.firstName("Michel")
				.surname("Kounga")
				.username("TheKoung")
				.build();
		return userDto;		
	}
	
	
	@Test
	@DisplayName("Test - Check Persistence Service not null")
	void init() {
		assertThat(persistenceService).isNotNull();
	}
	

	//@Test
	void testConvertToLayerObjectUp() {
	
	
		
	}

	//@Test
	void testConvertToLayerObjectDown() {
		UserJpaEntity userJpaEntity=UserJpaEntity.builder()
				.email("mrkounga@gmail.com")
				.firstName("Michel")			
				.username("TheKoung")
				.build();
		
	}

	//@Test
	void testCreate() {
		persistenceService.create(createNewDto());
	}

	//@Test
	void testFindEntityById() {
		persistenceService.findById(createNewDto().getId());
	}

//	@Test
	void testUpdate() {
		persistenceService.update(createNewDto());
	}

	//@Test
	void testDelete() {
		persistenceService.delete(createNewDto().getId());
	}

}
