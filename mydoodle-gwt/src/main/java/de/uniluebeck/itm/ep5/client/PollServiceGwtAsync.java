/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import de.uniluebeck.itm.ep5.poll.domain.xoPoll;
import de.uniluebeck.itm.pollservice.XsVote;
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

	public void getPoll(String url, String locale, String id,
			AsyncCallback<xoPoll> asyncCallback);

	public void voteForOptions(String url, List<String> ids, String voter,
			AsyncCallback<Void> asyncCallback);

	public void getLocalPollTitles(AsyncCallback<List<xoPoll>> asyncCallback);

	public void getLocalPoll(String id,
			AsyncCallback<xoPoll> asyncCallback);

	public void updatePoll(xoPoll poll,
			AsyncCallback<Void> asyncCallback);
}
