/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.server;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.uniluebeck.itm.ep5.client.PollServiceGwt;
import de.uniluebeck.itm.ep5.poll.bo.DateFormatter;
import de.uniluebeck.itm.ep5.poll.domain.IOption;
import de.uniluebeck.itm.ep5.poll.domain.XODateOption;
import de.uniluebeck.itm.ep5.poll.domain.XOOptionList;
import de.uniluebeck.itm.ep5.poll.domain.XOTextOption;
import de.uniluebeck.itm.ep5.poll.domain.xoPoll;
import de.uniluebeck.itm.ep5.poll.service.PollService;
import de.uniluebeck.itm.pollservice.PollWebService;
import de.uniluebeck.itm.pollservice.Pollservice;
import de.uniluebeck.itm.pollservice.XsOption;
import de.uniluebeck.itm.pollservice.XsOptionList;
import de.uniluebeck.itm.pollservice.XsPoll;
import de.uniluebeck.itm.pollservice.XsPollInfo;
import de.uniluebeck.itm.pollservice.XsVote;

/**
 *
 * @author hoschi
 */
public class PollServiceGwtImpl extends RemoteServiceServlet implements
		PollServiceGwt {

	@Override
	public List<xoPoll> getPollTitles(String url, String locale) {
		PollWebService service = getWebService(url);
		List<XsPollInfo> polls = service.getPolls(locale);
		List<xoPoll> list = new ArrayList<xoPoll>();
		for (XsPollInfo pollinfo : polls) {
			xoPoll poll = new xoPoll();
			poll.setTitle(pollinfo.getTitle());
			poll.setId(pollinfo.getId());
			list.add(poll);
		}
		return list;
	}

	@Override
	public List<xoPoll> getLocalPollTitles() {
		PollService service = getService();
		List<xoPoll> polls = service.getPolls();
		return polls;
	}

	private PollService getService() {
		ApplicationContext ctx;
		// Create the spring container using the XML configuration in
		// application-context.xml
		ctx = new ClassPathXmlApplicationContext(
				"application-context.xml");
		return (PollService) ctx.getBean("pollService");
	}
	private PollWebService getWebService(String url) {
		Pollservice instance = null;
		try {
			instance =
					new Pollservice(new URL(url),
					new QName("www.itm.uniluebeck.de/pollservice", "Pollservice"));
		} catch (MalformedURLException ex) {
			Logger.getLogger(PollServiceGwtImpl.class.getName()).
					log(Level.SEVERE, null, ex);
		}
		return instance.getPollWebServicePort();
	}

	@Override
	public void addPoll(xoPoll poll) {
		getService().addPoll(poll);
	}

	@Override
	public xoPoll getPoll(String url, String locale, String id) {
		PollWebService webService = getWebService(url);
		XsPoll webPoll = webService.getPoll(id.toString(), locale);
		xoPoll poll = new xoPoll();
		poll.setId(webPoll.getId());
		poll.setTitle(webPoll.getTitle());
		for (XsOptionList optionListWeb : webPoll.getOptionList()) {
			XOOptionList optionList = new XOOptionList();
			optionList.setTitle(optionListWeb.getTitle());
			optionList.setId(new Integer(optionListWeb.getId()));
			for (XsOption optionWeb : optionListWeb.getOption()) {
				IOption option;
				if (optionWeb.getDateTime() == null) {
					// text option
					XOTextOption textOption = new XOTextOption();
					textOption.setId(textOption.getId());
					textOption.addString(optionWeb.getValue(), locale);
					option = textOption;
				} else if (optionWeb.getValue() == null) {
					// date option
					XODateOption dateOption = new XODateOption();
					dateOption.setId(optionWeb.getId());
					try {
						dateOption.setDate(DateFormatter.parseString(optionWeb.getDateTime()));
					} catch (Exception ex) {
						dateOption.setDate(null);
						Logger.getLogger(PollServiceGwtImpl.class.getName()).
								log(Level.SEVERE, null, ex);
					}
					option = dateOption;
				} else {
					throw new RuntimeException("unknow type");
				}

				for (String voter : optionWeb.getVotes().getVoter()) {
					option.addVote(voter);
				}
				optionList.addOption(option);
			}
			poll.addOptionList(optionList);

		}
		return poll;
	}

	@Override
	public void voteForOptions(String url, List<String> ids, String voter) {
		PollWebService webService = getWebService(url);
		XsVote vote = new XsVote();
		vote.setVoter(voter);
		for (String id : ids){
				vote.getOptionId().add(id);
		}
		webService.voteForOptions(vote);
	}

	@Override
	public xoPoll getLocalPoll(String id) {
		return getService().getPoll(id);
	}

	@Override
	public void updatePoll(xoPoll poll) {
		this.getService().updatePoll(poll);
	}



	
}
