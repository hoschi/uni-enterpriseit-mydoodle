/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import de.uniluebeck.itm.ep5.poll.domain.xoPoll;
import de.uniluebeck.itm.pollservice.XsVote;
import java.util.List;

/**
 *
 * @author hoschi
 */
@RemoteServiceRelativePath("poll")

public interface PollServiceGwt extends RemoteService {

	public List<xoPoll> getPollTitles(String url, String locale);

	public List<xoPoll> getLocalPollTitles();

	public void addPoll(xoPoll poll);

	public void updatePoll(xoPoll poll);

	public xoPoll getPoll(String url, String locale, String id);

	public xoPoll getLocalPoll(String id);

	public void voteForOptions(String url, List<String> ids, String voter);
}
