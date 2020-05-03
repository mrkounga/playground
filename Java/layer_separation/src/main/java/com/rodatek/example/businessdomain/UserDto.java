package com.rodatek.example.businessdomain;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.domain.user.User;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UserDto implements User, IDto{
	
	private Long id;
	private String username;
	private String surname;
	private String firstName;
	private String email;
	
	
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
}
