/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import de.uniluebeck.itm.ep5.client.PollServiceGwt;
import de.uniluebeck.itm.ep5.poll.domain.xoPoll;
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

	public List<xoPoll> myMethod(String s) {
		Pollservice instance = null;
		try {
			instance = new Pollservice(new URL("http://localhost:8080/poll?WSDL"), new QName("www.itm.uniluebeck.de/pollservice", "Pollservice"));
		} catch (MalformedURLException ex) {
			Logger.getLogger(PollServiceGwtImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		List<XsPollInfo> pollInfos =
				instance.getPollWebServicePort().
				getPolls(Locale.ENGLISH.toString());
		List<xoPoll> polls = new ArrayList<xoPoll>();
		for (XsPollInfo info : pollInfos) {
			xoPoll x = new xoPoll();
			x.setId(new Integer(info.getId()));
			x.setTitle(info.getTitle());
			polls.add(x);
		}
		
		return polls;
	}
}
