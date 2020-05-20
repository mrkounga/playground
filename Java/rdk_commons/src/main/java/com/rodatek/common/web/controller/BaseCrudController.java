package com.rodatek.common.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rodatek.common.base.BaseObject;

public interface BaseCrudController<T extends BaseObject> {
	public ResponseEntity<List<T>> getAll();
	public ResponseEntity<List<T>> getPaginated(int pageNo, int pageSize);
	public ResponseEntity<T> getOne(final long id);
	public ResponseEntity<T> getCount();
	public void deleteOne(final long id) ;
	public void delete(T entity);
	public ResponseEntity<T> create(T entity);
	public ResponseEntity<T> update(Long id);
}
