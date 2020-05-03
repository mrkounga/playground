package com.rodatek.common.restapi;



public class AbstractController<R extends IResource>  {

	protected ControllerService<R> resourceService;

	public AbstractController(ControllerService<R> service) {
		this.resourceService = service;

	}
	
}
