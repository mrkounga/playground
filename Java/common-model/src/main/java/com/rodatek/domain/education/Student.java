package com.rodatek.domain.education;

import com.rodatek.domain.customer.Account;
import com.rodatek.domain.person.Person;

public interface Student extends Person{
	String getStudentNumber();
	Account getStudentAccount();
	Subject getSubject();
}
