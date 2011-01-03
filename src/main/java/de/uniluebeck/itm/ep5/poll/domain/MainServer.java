/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.poll.domain;

import de.uniluebeck.itm.ep5.poll.service.PollWebServiceImpl;
import javax.xml.ws.Endpoint;

/**
 *
 * @author hoschi
 */
public class MainServer {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/poll", new PollWebServiceImpl());
	}
}
