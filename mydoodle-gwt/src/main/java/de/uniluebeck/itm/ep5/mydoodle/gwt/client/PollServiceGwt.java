/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.mydoodle.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *
 * @author hoschi
 */
@RemoteServiceRelativePath("poll")

public interface PollServiceGwt extends RemoteService {

	public String myMethod(String s);
}
