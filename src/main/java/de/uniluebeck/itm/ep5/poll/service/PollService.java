package de.uniluebeck.itm.ep5.poll.service;

import java.util.List;

import de.uniluebeck.itm.ep5.poll.domain.Poll;

public interface PollService {

	void addPoll(Poll poll);

	void updatePoll(Poll poll);

	List<Poll> getPolls();

	List<Poll> search(String search);
}
