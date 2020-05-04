package com.rodatek.example.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodatek.common.restapi.AbstractController;
import com.rodatek.common.restapi.ControllerService;


@RestController
@RequestMapping(value = "/users")
public class UserApiController  extends AbstractController<UserResource> implements UserApi  {

	private UserResourceService resourceService;
	
	public UserApiController(UserResourceService service) {
		super(service);
		this.resourceService = service;
	}
	

}
