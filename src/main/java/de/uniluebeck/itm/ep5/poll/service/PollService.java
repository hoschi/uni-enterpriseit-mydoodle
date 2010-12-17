package de.uniluebeck.itm.ep5.poll.service;

import java.util.List;

import de.uniluebeck.itm.ep5.poll.domain.boPoll;
import de.uniluebeck.itm.ep5.poll.domain.xoPoll;

public interface PollService {

	void addPoll(xoPoll poll);

	void updatePoll(xoPoll poll);

	List<xoPoll> getPolls();

	List<xoPoll> search(String search);

	xoPoll getPoll(Integer integer);
}
