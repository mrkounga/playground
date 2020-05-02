package com.rodatek.domain.roster;

import java.time.LocalDate;

public interface Roster {
	String getName();
	LocalDate startDate();
	LocalDate endDate();
	Roster getRoster();
	Activity getActivity();
	Participant getParticipant();

}
