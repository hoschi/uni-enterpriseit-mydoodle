package de.uniluebeck.itm.ep5.poll.repository;

import org.springframework.stereotype.Repository;

import de.uniluebeck.itm.ep5.poll.domain.Poll;

@Repository
public class PersistentPollRepository extends
		AbstractPersistentRepository<Poll> implements PollRepository {

	public PersistentPollRepository() {
		super(Poll.class);
	}
}
