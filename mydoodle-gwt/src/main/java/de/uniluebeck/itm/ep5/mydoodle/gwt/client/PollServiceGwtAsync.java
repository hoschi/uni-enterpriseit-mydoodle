/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.mydoodle.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 *
 * @author hoschi
 */
public interface PollServiceGwtAsync {

	public void myMethod(String s, AsyncCallback<String> callback);
}
