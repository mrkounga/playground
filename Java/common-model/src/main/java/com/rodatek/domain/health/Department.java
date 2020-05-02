package com.rodatek.domain.health;


import com.rodatek.domain.roster.Roster;

import java.util.List;

import com.rodatek.domain.common.Descrable;
import com.rodatek.domain.common.Namable;

public interface Department extends Namable, Descrable{
	String getHoD();
	List<Roster> getRoster();
}
