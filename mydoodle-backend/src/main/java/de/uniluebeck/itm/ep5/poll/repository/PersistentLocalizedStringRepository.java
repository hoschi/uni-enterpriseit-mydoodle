package de.uniluebeck.itm.ep5.poll.repository;

import org.springframework.stereotype.Repository;

import de.uniluebeck.itm.ep5.poll.bo.BOLocalizedString;

@Repository
public class PersistentLocalizedStringRepository
extends AbstractPersistentRepository<BOLocalizedString>
implements LocalizedStringRepository {

	public PersistentLocalizedStringRepository() {
		super (BOLocalizedString.class);
	}
	
}
