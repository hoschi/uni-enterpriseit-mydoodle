/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import de.uniluebeck.itm.ep5.client.PollServiceGwt;
import de.uniluebeck.itm.ep5.gwt.GwtPoll;
import de.uniluebeck.itm.ep5.poll.domain.xoPoll;
import de.uniluebeck.itm.ep5.poll.service.PollService;
import de.uniluebeck.itm.pollservice.PollWebService;
import de.uniluebeck.itm.pollservice.Pollservice;
import de.uniluebeck.itm.pollservice.XsPollInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author hoschi
 */
public class PollServiceGwtImpl extends RemoteServiceServlet implements PollServiceGwt {
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
	public List<GwtPoll> getPollTitles() {
		PollWebService service = getWebService();
		List<XsPollInfo> polls = service.getPolls(Locale.ENGLISH.toString());
		List<GwtPoll> list = new ArrayList<GwtPoll>();
		for (XsPollInfo pollinfo : polls) {
			GwtPoll poll = new GwtPoll();
			poll.setTitle(pollinfo.getTitle());
			poll.setId(new Integer(pollinfo.getId()));
			list.add(poll);
		}
		return list;
	}

	private PollWebService getWebService() {
		Pollservice instance = null;
		try {
			instance =
					new Pollservice(new URL("http://localhost:8080/poll?WSDL"),
					new QName("www.itm.uniluebeck.de/pollservice", "Pollservice"));
		} catch (MalformedURLException ex) {
			Logger.getLogger(PollServiceGwtImpl.class.getName()).
					log(Level.SEVERE, null, ex);
		}
		return instance.getPollWebServicePort();
	}

	@Override
	public void addPoll(GwtPoll poll) {
		xoPoll x = new xoPoll();
		x.setActiveTimeSpan(poll.getStartDate(), poll.getEndDate());
		x.setOptions(null);
		x.setPublic(poll.isIsPublic());
		x.setTitle(poll.getTitle());

		if (service == null) {
			throw new RuntimeException("spring is dooof");
		}
		service.addPoll(x);
	}
}
