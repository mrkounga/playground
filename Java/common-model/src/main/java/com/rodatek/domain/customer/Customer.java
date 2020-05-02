package com.rodatek.domain.customer;

import com.rodatek.domain.person.Person;

public interface Customer extends Person{
	Account getAccount();

}
