package com.rodatek.common.repository.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.MappedSuperclass;

import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.repository.CrudRepository;
import org.springframework.util.Assert;

@MappedSuperclass
public abstract class AbstractAggregateRoot<ID extends GenericIdentifier> extends AbstractEntity<ID> {

	private transient final Collection<Object> events = new ArrayList<>();

	/**
	 * Registers the given event with the aggregate root for publication on persisting, i.e.
	 * {@link CrudRepository#save(Object)}.
	 *
	 * @param <T> the type of the event
	 * @param event must not be {@literal null}.
	 * @return
	 */
	protected final <T> T registerEvent(T event) {

		Assert.notNull(event, "Event must not be null!");

		this.events.add(event);

		return event;
	}

	/**
	 * Exposes the events to the publication infrastructure.
	 *
	 * @return the events to be published.
	 */
	@DomainEvents
	Collection<Object> getEvents() {
		return Collections.unmodifiableCollection(events);
	}

	/**
	 * Resets the events after publication.
	 */
	@AfterDomainEventPublication
	void wipeEvents() {
		this.events.clear();
	}
}

