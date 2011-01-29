/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import de.uniluebeck.itm.ep5.client.PollServiceGwt;
import de.uniluebeck.itm.ep5.mydoodle.gwt.GwtPoll;
import de.uniluebeck.itm.ep5.poll.domain.xoPoll;
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

/**
 *
 * @author hoschi
 */
public class PollServiceGwtImpl extends RemoteServiceServlet implements PollServiceGwt {

	@Override
	public List<String> getPollTitles() {
		PollWebService service = getService();
		List<XsPollInfo> polls = service.getPolls(Locale.ENGLISH.toString());
		List<String> list = new ArrayList<String>();
		for (XsPollInfo pollinfo : polls) {
			list.add(pollinfo.getTitle());
		}
		return list;
	}

	private PollWebService getService() {
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

		
	}
}
