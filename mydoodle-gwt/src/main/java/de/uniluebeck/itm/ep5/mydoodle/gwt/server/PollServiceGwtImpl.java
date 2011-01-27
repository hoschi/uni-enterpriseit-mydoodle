/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.mydoodle.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import de.uniluebeck.itm.ep5.mydoodle.gwt.client.PollServiceGwt;

/**
 *
 * @author hoschi
 */
public class PollServiceGwtImpl extends RemoteServiceServlet implements PollServiceGwt {

	public String myMethod(String s) {
		return "foooo you " + s;
	}
}
