/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import de.uniluebeck.itm.ep5.client.PollServiceGwt;
import de.uniluebeck.itm.ep5.poll.domain.xoPoll;
import de.uniluebeck.itm.ep5.poll.service.PollService;
import de.uniluebeck.itm.pollservice.PollWebService;
import de.uniluebeck.itm.pollservice.Pollservice;
import de.uniluebeck.itm.pollservice.XsPollInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author hoschi
 */
public class PollServiceGwtImpl extends RemoteServiceServlet implements
		PollServiceGwt {

	PollService service;

	public PollServiceGwtImpl() {
		ApplicationContext ctx;
		// Create the spring container using the XML configuration in
		// application-context.xml
		ctx = new ClassPathXmlApplicationContext(
				"application-context.xml");
		this.service = (PollService) ctx.getBean("pollService");
	}

	@Override
	public List<xoPoll> getPollTitles(String url, String locale) {
		PollWebService service = getWebService(url);
		List<XsPollInfo> polls = service.getPolls(locale);
		List<xoPoll> list = new ArrayList<xoPoll>();
		for (XsPollInfo pollinfo : polls) {
			xoPoll poll = new xoPoll();
			poll.setTitle(pollinfo.getTitle());
			poll.setId(new Integer(pollinfo.getId()));
			list.add(poll);
		}
		return list;
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
		xoPoll x = new xoPoll();
		x.setActiveTimeSpan(poll.getStartDate(), poll.getEndDate());
		x.setOptions(null);
		x.setPublic(poll.isPublic());
		x.setTitle(poll.getTitle());

		service.addPoll(x);
	}

	@Override
	public xoPoll getPoll(int id) {
		return service.getPoll(id);
	}
}
