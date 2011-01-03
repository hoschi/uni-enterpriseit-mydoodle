/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.poll.service;

import de.uniluebeck.itm.ep5.poll.domain.IOption;
import de.uniluebeck.itm.ep5.poll.domain.XODateOption;
import de.uniluebeck.itm.ep5.poll.domain.XOOptionList;
import de.uniluebeck.itm.ep5.poll.domain.XOTextOption;
import de.uniluebeck.itm.ep5.poll.domain.xoPoll;
import de.uniluebeck.itm.pollservice.PollWebService;
import de.uniluebeck.itm.pollservice.XsOption;
import de.uniluebeck.itm.pollservice.XsOptionList;
import de.uniluebeck.itm.pollservice.XsPoll;
import de.uniluebeck.itm.pollservice.XsPollInfo;
import de.uniluebeck.itm.pollservice.XsVote;
import de.uniluebeck.itm.pollservice.XsVotes;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author hoschi
 */
@WebService(portName = "PollWebServicePort", serviceName = "Pollservice", targetNamespace = "www.itm.uniluebeck.de/pollservice", endpointInterface = "de.uniluebeck.itm.pollservice.PollWebService", wsdlLocation = "WEB-INF/Pollservice.wsdl")
public class PollWebServiceImpl implements PollWebService {

	final static Logger logger =
			LoggerFactory.getLogger(PollWebServiceImpl.class);
	ApplicationContext ctx;
	PollService pollService;

	public PollWebServiceImpl() {
		// Create the spring container using the XML configuration in
		// application-context.xml
		ctx = new ClassPathXmlApplicationContext(
				"application-context.xml");

		// Retrieve the beans we'll use during testing
		pollService = ctx.getBean(PollService.class);
	}

	@Override
	public List<XsPollInfo> getPolls(String languageCode) {
		List<xoPoll> polls = pollService.getPolls();
		List<XsPollInfo> list = new ArrayList<XsPollInfo>();
		for (xoPoll poll : polls) {
			XsPollInfo info = new XsPollInfo();
			info.setId(poll.getId().toString());
			info.setTitle(poll.getTitle());
			list.add(info);
		}
		return list;
	}

	@Override
	public XsPoll getPoll(String pollId, String languageCode) {
		if (pollId == null)
			return null;
		
		xoPoll poll = pollService.getPoll(new Integer(pollId));
		XsPoll xs = new XsPoll();
		xs.setId(poll.getId().toString());
		xs.setTitle(poll.getTitle());

		// add options recursively
		for (XOOptionList list : poll.getOptionLists()) {
			XsOptionList xsList = new XsOptionList();
			xsList.setTitle(list.getTitle());

			// all date options
			for (IOption option : list.getDates()) {
				XsOption op = new XsOption();
				XODateOption date = (XODateOption) option;
				op.setDateTime(date.toString());
				op.setId(date.getId().toString());
				XsVotes votes = new XsVotes();
				for (String voter : date.getVotes()) {
					votes.getVoter().add(voter);
				}
				op.setVotes(votes);
				xsList.getOption().add(op);
			}

			// all text options
			for (IOption option : list.getTexts()) {
				XsOption op = new XsOption();
				XOTextOption text = (XOTextOption) option;
				op.setValue(text.getStringByLocale(languageCode));
				op.setId(text.getId().toString());
				XsVotes votes = new XsVotes();
				for (String voter : text.getVotes()) {
					votes.getVoter().add(voter);
				}
				op.setVotes(votes);
				xsList.getOption().add(op);
			}

			xs.getOptionList().add(xsList);
		}
		return xs;
	}

	@Override
	public void voteForOptions(XsVote voteForOptions) {
		for (String id : voteForOptions.getOptionId()) {
			IOption option = pollService.getOption(id);
			option.addVote(voteForOptions.getVoter());
			pollService.updateOption(option);
		}
	}
}
