/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import de.uniluebeck.itm.ep5.gwt.GwtPoll;
import java.util.List;

/**
 *
 * @author hoschi
 */
@RemoteServiceRelativePath("poll")

public interface PollServiceGwt extends RemoteService {

	public List<String> getPollTitles();

	public void addPoll(GwtPoll poll);
}
