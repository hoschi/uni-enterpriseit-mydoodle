/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.uniluebeck.itm.ep5.poll.service;

import de.uniluebeck.itm.ep5.poll.domain.xoPoll;
import de.uniluebeck.itm.pollservice.PollWebService;
import de.uniluebeck.itm.pollservice.XsPoll;
import de.uniluebeck.itm.pollservice.XsPollInfo;
import de.uniluebeck.itm.pollservice.XsVote;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author hoschi
 */
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
		return null;
	}

	@Override
	public void voteForOptions(XsVote voteForOptions) {
	}

}
