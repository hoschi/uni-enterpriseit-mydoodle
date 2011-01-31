/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.uniluebeck.itm.ep5.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import java.util.Iterator;

/**
 *
 * @author hoschi
 */
public class SearchIndicator {
	Panel panel;
	Label title;
	Label searchIndicator = new Label(">>>>>>>>>>>>>>>");

	public SearchIndicator(String title) {
		this.title = new Label(title);
		this.panel = new HorizontalPanel();
		searchIndicator.setVisible(false);
		panel.add(searchIndicator);
		panel.add(this.title);
	}

	public void reset() {
		this.searchIndicator.setVisible(false);
	}

	public String getText() {
		return title.getText();
	}

	public void setVisible(boolean visible) {
		this.searchIndicator.setVisible(visible);
	}

	public Panel getPanel() {
		return this.panel;
	}

	void match(String search) {
		if (title.getText().matches(search)) {
			this.searchIndicator.setVisible(true);
		}
	}


}
