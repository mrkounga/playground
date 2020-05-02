package com.rodatek.domain.health;

import java.util.List;

import com.rodatek.domain.organization.Organization;
import com.rodatek.domain.roster.Roster;

public interface Hospital extends Organization{
	String getCategory();
	List<Roster> getRoster();

}
