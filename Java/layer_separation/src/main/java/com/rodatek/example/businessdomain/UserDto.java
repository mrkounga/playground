package com.rodatek.example.businessdomain;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.domain.user.User;


public class UserDto implements User, IDto{
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

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFirsName() {
		// TODO Auto-generated method stub
		return null;
	}

}
