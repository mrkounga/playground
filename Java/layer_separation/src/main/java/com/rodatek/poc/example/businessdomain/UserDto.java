package com.rodatek.poc.example.businessdomain;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.domain.user.User;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto implements  IDto{
	
	private String id;
	private String username;
	private String surname;
	private String firstname;
	private String email;
	
	
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
}
