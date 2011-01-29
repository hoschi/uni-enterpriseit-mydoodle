/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import de.uniluebeck.itm.ep5.poll.domain.xoPoll;
import java.util.List;

/**
 *
 * @author hoschi
 */
public interface PollServiceGwtAsync {

	public void getPollTitles(String url, String locale,
			AsyncCallback<List<xoPoll>> asyncCallback);

	public void addPoll(xoPoll poll,
			AsyncCallback<Void> asyncCallback);

	public void getPoll(int id,
			AsyncCallback<xoPoll> asyncCallback);
}
