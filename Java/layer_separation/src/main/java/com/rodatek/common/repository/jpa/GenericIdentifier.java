package com.rodatek.common.repository.jpa;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@MappedSuperclass
@Access(AccessType.FIELD)
@RequiredArgsConstructor
@EqualsAndHashCode
public class GenericIdentifier implements Serializable {

	private static final long serialVersionUID = -859038278950680970L;

	private final @Column(unique = true) String id;

	public GenericIdentifier() {
		this.id = UUID.randomUUID().toString();
	}

	public String getIdentifier() {
		return id;
	}

	
	@Override
	public String toString() {
		return id;
	}
}