package de.uniluebeck.itm.ep5.poll.repository;

import org.springframework.stereotype.Repository;

import de.uniluebeck.itm.ep5.poll.domain.BODateOption;

@Repository
public class PersistentDateOptionRepository 
extends AbstractPersistentRepository<BODateOption>
implements DateOptionRepository {

	public PersistentDateOptionRepository() {
		super (BODateOption.class);
	}
	
}