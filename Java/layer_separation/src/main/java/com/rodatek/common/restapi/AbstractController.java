package com.rodatek.common.restapi;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rodatek.poc.example.api.UserResource;

//@RestController
public class AbstractController<R extends IResource> {

	protected ControllerService<R> resourceService;

	public AbstractController(ControllerService<R> service) {
		this.resourceService = service;

	}

	@GetMapping("/{id}")
	public ResponseEntity<R> getOne(@PathVariable("id") long id) {
		return new ResponseEntity(resourceService.findRessourceById(id), HttpStatus.FOUND);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOne(@PathVariable("id") final long id) {
		resourceService.deleteResourceById(id);

	}

	@GetMapping()
	public ResponseEntity<R> getOne() {
		UserResource userResource = UserResource.builder().email("mrkounga@faketest.com").firstName("michel")
				.surname("kounga").build();
		return new ResponseEntity(userResource, HttpStatus.FOUND);

	}

	@PostMapping()
	public ResponseEntity<R> create(@Valid R entity) {
		return new ResponseEntity(resourceService.createResource(entity), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<R> update(@PathVariable("id") R resource) {
		return new ResponseEntity(resourceService.updateResource(resource), HttpStatus.OK);
	}

}
