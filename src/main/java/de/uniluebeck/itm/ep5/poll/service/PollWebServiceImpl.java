/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.uniluebeck.itm.ep5.poll.service;

import de.uniluebeck.itm.pollservice.PollWebService;
import de.uniluebeck.itm.pollservice.XsPoll;
import de.uniluebeck.itm.pollservice.XsPollInfo;
import de.uniluebeck.itm.pollservice.XsVote;
import java.util.List;

/**
 *
 * @author hoschi
 */
public class PollWebServiceImpl implements PollWebService {

	@Override
	public List<XsPollInfo> getPolls(String languageCode) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public XsPoll getPoll(String pollId, String languageCode) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void voteForOptions(XsVote voteForOptions) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
