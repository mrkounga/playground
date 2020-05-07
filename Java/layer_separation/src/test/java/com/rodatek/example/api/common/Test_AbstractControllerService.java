package com.rodatek.example.api.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.restapi.ControllerService;
import com.rodatek.common.restapi.IResource;



@SpringJUnitConfig()
@SpringBootTest
@DisplayName(value = "Test - Resource Service")
public abstract class Test_AbstractControllerService<R extends IResource> {
	

	protected abstract ControllerService<R> getControllerService();
	
	protected abstract R givenResource();
	
	protected abstract <D extends IDto> D givenDto();
	
	protected abstract void testConvertToLayerObjectUp();
	
	protected abstract void testConvertToLayerObjectDown();
	
	
	@Test
	@DisplayName("Test - Resource Service : Resource Creation")
	void testCreateResource() {
		//Arrange
		R toCreated=givenResource();
		
		//Act
		R createdResource=getControllerService().createResource(toCreated);
		
		//Assert
		assertThat(createdResource.getId()).isGreaterThan(0);
		
	}

	@Test
	@DisplayName("Test - Resource Service : Find Resource by Id")
	void testFindRessourceById() {
		//Arrange
		R createdResource=getControllerService().createResource(givenResource());
		
		//Act
		R foundedResource = getControllerService().findRessourceById(createdResource.getId()).get();
		
		//Assert
		assertThat(foundedResource.getId()).isEqualTo(createdResource.getId());
		
	}

	@Test
	@DisplayName("Test - Resource Service : Delete Resource by Id")
	void testDeleteResourceById() {
		//Arrange
		R createdResource=getControllerService().createResource(givenResource());
		
		//Act
		getControllerService().deleteResourceById(createdResource.getId());
		
		//Assert
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			getControllerService().findRessourceById(createdResource.getId());
		});
		
	}


}
