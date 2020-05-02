package com.rodatek.domain.health;

import com.rodatek.domain.person.Person;

public interface Doctor extends Person {
	String getGrade();
	String getCategory();
	Department getDepartment();

}
