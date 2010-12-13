package de.uniluebeck.itm.ep5.poll.repository;

import org.springframework.stereotype.Repository;

import de.uniluebeck.itm.ep5.poll.domain.BOOptionList;

@Repository
public class PersistentOptionListRepository 
extends AbstractPersistentRepository<BOOptionList>
implements OptionListRepository {

	public PersistentOptionListRepository() {
		super (BOOptionList.class);
	}
	
}
