/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import de.uniluebeck.itm.ep5.gwt.GwtPoll;
import java.util.List;

/**
 *
 * @author hoschi
 */
public interface PollServiceGwtAsync {

	public void addPoll(GwtPoll poll,
			AsyncCallback<Void> asyncCallback);

	public void getPollTitles(String url, String locale,
			AsyncCallback<List<GwtPoll>> asyncCallback);
}
