package com.rodatek.poc.businessdomain;

import com.rodatek.common.business.domain.IDto;

public class UserDto implements IDto{
	private String username;
	private String surname;
	private String firstName;
	private String email;
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

}
