package de.uniluebeck.itm.ep5.poll.repository;

import org.springframework.stereotype.Repository;

import de.uniluebeck.itm.ep5.poll.domain.BOTextOption;

@Repository
public class PersistentTextOptionRepository 
extends AbstractPersistentRepository<BOTextOption>
implements TextOptionRepository {

	public PersistentTextOptionRepository() {
		super (BOTextOption.class);
	}
	
}