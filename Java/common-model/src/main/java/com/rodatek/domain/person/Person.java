package com.rodatek.domain.person;

import java.util.Optional;

import com.rodatek.domain.address.Address;
import com.rodatek.domain.address.PhoneNumber;
import com.rodatek.domain.address.SocialMedia;

public interface Person {
	String getFirstName();
	String getLastName();
	String getGender();
	Address getAddress();
	Optional<String> getInitial();
	Optional<String> getEmail();	
	Optional<String> getIndentificationNumber();
	Optional<String> getIdentificationType();	
	Optional<PhoneNumber> getPhoneNumber();
	Optional<SocialMedia> getSocialMedia();
}
