package de.uniluebeck.itm.ep5.poll.service;

import java.util.List;

import de.uniluebeck.itm.ep5.poll.domain.Poll;
import de.uniluebeck.itm.ep5.poll.repository.PollRepository;

import org.springframework.transaction.annotation.Transactional;

public class PollServiceImpl implements PollService {

	private PollRepository pollRepository;

	@Transactional
	public void addPoll(Poll poll) {
		pollRepository.add(poll);
	}

	@Transactional
	public void updatePoll(Poll poll) {
		pollRepository.update(poll);
	}

	@Transactional(readOnly = true)
	public List<Poll> getPolls() {
		return pollRepository.findAll();
	}

	/**
	 * Used by Spring to inject the PollRepository.
	 * @param pollRepository
	 */
	public void setPollRepository(PollRepository pollRepository) {
		this.pollRepository = pollRepository;
	}
}
