package com.rodatek.common.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.google.common.base.Strings;
import com.rodatek.common.base.BaseObject;
import com.rodatek.common.persistence.BaseRepository;


public abstract class  BaseServiceImpl<T extends  BaseObject> implements BaseService<T> {

	protected BaseRepository<T> repository;

	public BaseServiceImpl(BaseRepository<T> repo) {
		this.repository = repo;
	}

	public T create(T e) {
		if (e.isValid()) {
			return repository.save(e);
		} else
			return null;
	}

	public T update(T e) {
		if ( e.isValid() && repository.existsById(e.getId())) {
			return repository.save(e);
		} else
			return null;
	}

	public List<T> findPaginated(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<T> pageResult = repository.findAll(paging);
		return pageResult.getContent();
	}

	public T findByName(String name) {
		if (Strings.isNullOrEmpty(name)) {
			return (T) repository.findByName(name);
		} else {
			return null;
		}
	}

	public T findById(long id) {
		return repository.findById(id).get();
	}

	public void delete(long id) {
		if (findById(id) != null) {
			repository.deleteById(id);
		}

	}

	public long count() {
		return repository.count();
	}

	public void delete(T e) {
		repository.delete(e);		
	}

	public List<T> getAll() {
		// TODO Auto-generated method stub
		return (List<T>) repository.findAll();
	}

	//to be implemented
	public T update(Long id) {
		return null;
		//return repository.save(entity.)?repository.existsById(id):null
	}
}
