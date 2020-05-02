package com.rodatek.common.restapi;



public class AbstractController<R extends IResource>  {

	protected ResourceService<R> resourceService;

	public AbstractController(ResourceService<R> service) {
		this.resourceService = service;

	}
	
}
