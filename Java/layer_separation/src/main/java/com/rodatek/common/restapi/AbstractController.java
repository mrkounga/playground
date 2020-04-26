package com.rodatek.common.restapi;

import java.util.Optional;

public class AbstractController<R extends IResource> implements ApiOperation<R> {

	private ResourceService<R> service;

	public AbstractController(ResourceService<R> service) {
		this.service = service;

	}

	public R createResource(R resource) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<R> getResource(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
