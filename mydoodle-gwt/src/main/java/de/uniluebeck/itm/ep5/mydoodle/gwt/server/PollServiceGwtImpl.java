/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.mydoodle.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import de.uniluebeck.itm.ep5.mydoodle.gwt.client.PollServiceGwt;
import de.uniluebeck.itm.pollservice.Pollservice;
import de.uniluebeck.itm.pollservice.XsPollInfo;
import java.net.MalformedURLException;
import java.net.URL;
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

	public String myMethod(String s) {
		Pollservice instance = null;
		try {
			instance = new Pollservice(new URL("http://localhost:8080/poll?WSDL"), new QName("www.itm.uniluebeck.de/pollservice", "Pollservice"));
		} catch (MalformedURLException ex) {
			Logger.getLogger(PollServiceGwtImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		List<XsPollInfo> polls = instance.getPollWebServicePort().getPolls(Locale.ENGLISH.toString());
		return "size " + polls.size();
	}
}
