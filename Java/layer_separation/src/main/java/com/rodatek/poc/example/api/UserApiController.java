package com.rodatek.poc.example.api;

import org.springframework.web.bind.annotation.RequestMapping;

import com.rodatek.common.restapi.AbstractController;


//@RestController
@RequestMapping(value = "/users")
public class UserApiController  extends AbstractController<UserResource> implements UserApi  {

	private UserResourceService resourceService;
	
	public UserApiController(UserResourceService service) {
		super(service);
		this.resourceService = service;
	}
	

}
