package com.rodatek.common.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rodatek.common.base.BaseObject;
import com.rodatek.common.service.BaseService;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class BaseCrudControllerImpl<E extends BaseObject> implements BaseCrudController<E> {

	protected final BaseService<E> service;

	@Autowired
	public BaseCrudControllerImpl(BaseService<E> abstractService) {
		this.service = abstractService;
	}

	// only for dev
	@GetMapping()
	public ResponseEntity<List<E>> getAll() {
		List<E> entityList = service.getAll();
		return new ResponseEntity(entityList, HttpStatus.OK);
	}

	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<List<E>> getPaginated(@PathVariable int pageNo, @PathVariable int pageSize) {
		List<E> entityList = service.findPaginated(pageNo, pageSize);
		return new ResponseEntity(entityList, HttpStatus.OK);
		// return null;
	}

	@GetMapping("/{id}")
	public ResponseEntity<E> getOne(@PathVariable("id") long id) {
		return new ResponseEntity(service.findById(id), HttpStatus.FOUND);
	}

	@GetMapping("/count")
	public ResponseEntity<E> getCount() {
		return new ResponseEntity(service.count(), HttpStatus.FOUND);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOne(@PathVariable("id") final long id) {
		service.delete(id);

	}

	@DeleteMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@Valid E entity) {
		service.delete(entity);

	}

	@PostMapping()
	public ResponseEntity<E> create(@Valid E entity) {
		return new ResponseEntity(service.create(entity), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<E> update(@PathVariable("id") final Long id) {
		return new ResponseEntity(service.update(id), HttpStatus.OK);
	}
	


}
