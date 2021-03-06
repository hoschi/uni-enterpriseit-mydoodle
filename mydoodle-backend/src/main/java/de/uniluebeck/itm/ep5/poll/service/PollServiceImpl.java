package de.uniluebeck.itm.ep5.poll.service;

import de.uniluebeck.itm.ep5.poll.domain.XODateOption;
import de.uniluebeck.itm.ep5.poll.domain.XOTextOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import de.uniluebeck.itm.ep5.poll.bo.BODateOption;
import de.uniluebeck.itm.ep5.poll.bo.BOLocalizedString;
import de.uniluebeck.itm.ep5.poll.bo.BOOptionList;
import de.uniluebeck.itm.ep5.poll.bo.BOTextOption;
import de.uniluebeck.itm.ep5.poll.domain.IOption;
import de.uniluebeck.itm.ep5.poll.bo.PollMapper;
import de.uniluebeck.itm.ep5.poll.bo.boPoll;
import de.uniluebeck.itm.ep5.poll.domain.xoPoll;
import de.uniluebeck.itm.ep5.poll.repository.DateOptionRepository;
import de.uniluebeck.itm.ep5.poll.repository.LocalizedStringRepository;
import de.uniluebeck.itm.ep5.poll.repository.OptionListRepository;
import de.uniluebeck.itm.ep5.poll.repository.PollRepository;
import de.uniluebeck.itm.ep5.poll.repository.TextOptionRepository;
import de.uniluebeck.itm.ep5.util.InactiveExcepiton;
import de.uniluebeck.itm.ep5.util.Wildcard;
import java.util.HashSet;
import java.util.Set;

public class PollServiceImpl implements PollService {

	private PollRepository pollRepository;
	private OptionListRepository optionListRepository;
	private TextOptionRepository textOptionRepository;
	private DateOptionRepository dateOptionRepository;
	private LocalizedStringRepository localizedStringRepository;

	@Transactional
	@Override
	public void addPoll(xoPoll poll) {
		boPoll b = PollMapper.createBO(poll);
		handleOptionLists(b.getOptions());
		pollRepository.add(b);
		poll.setId(b.getId());
		poll.setOptions(PollMapper.createXO(b.getOptions()));
	}

	private void handleOptionLists(List<BOOptionList> lists) {
		if (lists != null) {
			for (BOOptionList list : lists) {
				handleOptionList(list);
			}
		}
	}

	private void handleOptionList(BOOptionList list) {
		handleDateOptions(list.getDates());
		handleTextOptions(list.getTexts());
		if (list.getId() == null) {
			optionListRepository.add(list);
		} else {
			optionListRepository.update(list);
		}
	}

	private void handleTextOptions(List<IOption> texts) {
		for (IOption option : texts) {
			handleTextOption((BOTextOption) option);
		}
	}

	private void handleTextOption(BOTextOption option) {
		handleLocalizedStrings(option.getStrings());
		if (option.getId() == null) {
			textOptionRepository.add(option);
		} else {
			textOptionRepository.update(option);
		}
	}

	private void handleLocalizedStrings(List<BOLocalizedString> strings) {
		for (BOLocalizedString string : strings) {
			handleLocalizedString(string);
		}
	}

	private void handleLocalizedString(BOLocalizedString string) {
		if (string.getId() == null) {
			localizedStringRepository.add(string);
		} else {
			localizedStringRepository.update(string);
		}
	}

	private void handleDateOptions(List<IOption> dates) {
		for (IOption option : dates) {
			handleTextOption((BODateOption) option);
		}
	}

	private void handleTextOption(BODateOption option) {
		if (option.getId() == null) {
			dateOptionRepository.add(option);
		} else {
			dateOptionRepository.update(option);
		}
	}

	@Transactional
	@Override
	public xoPoll updatePoll(xoPoll poll) {
		boPoll b = PollMapper.createBO(poll);
		if (!b.isActive()) {
			throw new InactiveExcepiton("you can't do this");
		}
		handleOptionLists(b.getOptions());
		b = pollRepository.update(b);
		return PollMapper.createXO(b);
	}

	@Transactional(readOnly = true)
	@Override
	public List<xoPoll> getPolls() {
		List<boPoll> all = pollRepository.findAll();
		List<xoPoll> trans = new ArrayList<xoPoll>();
		for (boPoll p : all) {
			xoPoll x = PollMapper.createXO(p);
			trans.add(x);
		}

		return trans;
	}

	@Transactional(readOnly = true)
	@Override
	public List<xoPoll> search(String search) {
		List<xoPoll> list = new ArrayList<xoPoll>();
		Wildcard wildcard = new Wildcard(search);
		for (xoPoll p : this.getPolls()) {
			if (wildcard.match(p.getTitle(), false)) {
				list.add(p);
			}
		}
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public xoPoll getPoll(String integer) {
                for (boPoll bop : this.pollRepository.findAll()) {
                    if (bop.getId().equals(integer))
                        return PollMapper.createXO(bop);
                }
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public xoPoll refresh(xoPoll poll) {
		boPoll b = PollMapper.createBO(poll);
		b = pollRepository.refresh(b);
		return PollMapper.createXO(b);
	}

	@Override
	@Transactional(readOnly = true)
	public IOption getOption(String id) {
		IOption option = null;
		for (BOTextOption o : textOptionRepository.findAll()) {
			if (o.getId().equals(id)) {
				option = PollMapper.createXO(o);
			}
		}
		for (BODateOption o : dateOptionRepository.findAll()) {
			if (o.getId().equals(id)) {
				option = PollMapper.createXO(o);
			}
		}
		return option;
	}

	@Override
	@Transactional
	public void updateOption(IOption option) {
		if (option instanceof XODateOption) {
			BODateOption date = PollMapper.createBO((XODateOption) option);
			date = dateOptionRepository.update(date);
			date.filterVotes();
			dateOptionRepository.add(date);
		} else if (option instanceof XOTextOption) {
			BOTextOption text = PollMapper.createBO((XOTextOption) option);
			// reatach object to entity mapper
			text = textOptionRepository.update(text);
			text.filterVotes();
			// update option
			textOptionRepository.add(text);
		}
	}

	/**
	 * Used by Spring to inject the PollRepository.
	 * @param pollRepository
	 */
	public void setPollRepository(PollRepository pollRepository) {
		this.pollRepository = pollRepository;
	}

	public void setOptionListRepository(OptionListRepository optionListRepository) {
		this.optionListRepository = optionListRepository;
	}

	public void setTextOptionRepository(TextOptionRepository textOptionRepository) {
		this.textOptionRepository = textOptionRepository;
	}

	public void setDateOptionRepository(DateOptionRepository dateOptionRepository) {
		this.dateOptionRepository = dateOptionRepository;
	}

	public void setLocalizedStringRepository(
			LocalizedStringRepository localizedStringRepository) {
		this.localizedStringRepository = localizedStringRepository;
	}
}
