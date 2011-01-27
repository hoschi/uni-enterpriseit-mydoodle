package de.uniluebeck.itm.ep5.poll.repository;

import org.springframework.stereotype.Repository;

import de.uniluebeck.itm.ep5.poll.domain.boPoll;

@Repository
public class PersistentPollRepository extends
		AbstractPersistentRepository<boPoll> implements PollRepository {

	public PersistentPollRepository() {
		super(boPoll.class);
	}
}
