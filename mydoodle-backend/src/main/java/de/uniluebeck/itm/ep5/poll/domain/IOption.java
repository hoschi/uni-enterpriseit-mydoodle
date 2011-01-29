/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.uniluebeck.itm.ep5.poll.domain;

import java.io.Serializable;

/**
 *
 * @author hoschi
 */
public interface IOption extends Serializable {
	public void addVote(String voter);
}
