package com.rodatek.domain.organization;

import com.rodatek.domain.address.Address;
import com.rodatek.domain.address.PhoneNumber;
import com.rodatek.domain.address.SocialMedia;
import com.rodatek.domain.common.Descrable;
import com.rodatek.domain.common.Namable;

public interface Organization extends Namable, Descrable{	
	String getCEO();
	String getEmail();
	String getWebsite();
	String getRegistratioNumber();
	String getIndustrySector();
	Address getAddress();
	PhoneNumber getPhoneNumber();
	SocialMedia getSocialMedia();
}
