package de.uniluebeck.itm.ep5.poll.repository;

import org.springframework.stereotype.Repository;

import de.uniluebeck.itm.ep5.poll.domain.BOVote;

@Repository
public class PersistentVoteRepository
extends AbstractPersistentRepository<BOVote>
implements VoteRepository {

	public PersistentVoteRepository() {
		super (BOVote.class);
	}
	
}