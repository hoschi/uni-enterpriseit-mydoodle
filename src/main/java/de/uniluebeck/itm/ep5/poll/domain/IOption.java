/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.uniluebeck.itm.ep5.poll.domain;

import java.util.List;

/**
 *
 * @author hoschi
 */
public interface IOption {
	public void setVotes(List<String> votes);
	public List<String> getVotes();

	public void addVote(String voter);
	public void removeVote(String voter);

}
