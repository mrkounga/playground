package com.rodatek.poc.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodatek.common.restapi.AbstractController;
import com.rodatek.common.restapi.ResourceService;


@RestController
@RequestMapping(value = "/users")
public class UserApiController  extends AbstractController<UserResource>  {

	private UserResourceService resourceService;
	
	public UserApiController(ResourceService<UserResource> service) {
		super(service);
		// TODO Auto-generated constructor stub
	}
	

}
