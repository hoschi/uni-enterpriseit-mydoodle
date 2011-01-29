package de.uniluebeck.itm.ep5.poll.service;

import de.uniluebeck.itm.ep5.poll.domain.IOption;
import de.uniluebeck.itm.ep5.poll.domain.XODateOption;
import de.uniluebeck.itm.ep5.poll.domain.XOTextOption;
import java.util.List;

import de.uniluebeck.itm.ep5.poll.bo.boPoll;
import de.uniluebeck.itm.ep5.poll.domain.xoPoll;

public interface PollService {

	void addPoll(xoPoll poll);

	xoPoll updatePoll(xoPoll poll);

	List<xoPoll> getPolls();

	List<xoPoll> search(String search);

	xoPoll getPoll(Integer integer);

	public xoPoll refresh(xoPoll poll);

	public IOption getOption(String id);

	public void updateOption(IOption option);

}
