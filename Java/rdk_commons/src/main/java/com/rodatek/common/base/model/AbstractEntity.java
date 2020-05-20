package com.rodatek.common.base.model;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString
@Data
public abstract class AbstractEntity extends AuditableRecord{
	
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "name", unique = true)
	protected String name;

	@NotNull
	@Column(name = "Description", unique = false)
	protected String description;
	
}
