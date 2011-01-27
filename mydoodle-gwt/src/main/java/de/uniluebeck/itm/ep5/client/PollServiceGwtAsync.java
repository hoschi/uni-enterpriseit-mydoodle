/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import de.uniluebeck.itm.pollservice.XsPollInfo;
import java.util.List;

/**
 *
 * @author hoschi
 */
public interface PollServiceGwtAsync {

	public void myMethod(String s, AsyncCallback<List<XsPollInfo>> asyncCallback);
}
