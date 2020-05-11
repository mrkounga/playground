package com.rodatek.poc.example.repository.jpa;

import javax.persistence.Embeddable;

import com.rodatek.common.repository.jpa.GenericIdentifier;

@Embeddable
public class UserIdentifier extends GenericIdentifier {

	private static final long serialVersionUID = -5507791041835505812L;
	
	/**
	 * Creates a new unique identifier for {@link User}.
	 */
	UserIdentifier() {
		super();
	}

	/**
	 * Only needed for property editor, shouldn't be used otherwise.
	 * 
	 * @param userIdentifier The string representation of the identifier.
	 */
	UserIdentifier(String userIdentifier) {
		super(userIdentifier);
	}

}
