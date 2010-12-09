package de.uniluebeck.itm.ep5.poll.service;

import java.util.List;

import de.uniluebeck.itm.ep5.poll.domain.Poll;
import de.uniluebeck.itm.ep5.poll.repository.PollRepository;
import de.uniluebeck.itm.ep5.util.Wildcard;
import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

public class PollServiceImpl implements PollService {

	
	private PollRepository pollRepository;

	@Transactional
	@Override
	public void addPoll(Poll poll) {
		pollRepository.add(poll);
	}

	@Transactional
	@Override
	public void updatePoll(Poll poll) {
		pollRepository.update(poll);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Poll> getPolls() {
		List<Poll> all = pollRepository.findAll();
		for (Poll p : all) {
			p.toString();
		}
		return all;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Poll> search(String search) {
		List<Poll> list = new ArrayList<Poll>();
		Wildcard wildcard = new Wildcard(search);
		for (Poll p : this.getPolls()) {
			if (wildcard.match(p.getTitle(), false)) {
				list.add(p);
			}
		}
		return list;
	}

	/**
	 * Used by Spring to inject the PollRepository.
	 * @param pollRepository
	 */
	public void setPollRepository(PollRepository pollRepository) {
		this.pollRepository = pollRepository;
	}
}
