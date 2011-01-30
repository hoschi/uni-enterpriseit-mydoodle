/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.uniluebeck.itm.ep5.client;

import com.google.gwt.user.client.ui.CheckBox;

/**
 *
 * @author hoschi
 */
public class VoteBox extends CheckBox {
	String optionId;

	public String getOptionId() {
		return optionId;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}
	

}
