/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import de.uniluebeck.itm.ep5.poll.domain.xoPoll;
import de.uniluebeck.itm.pollservice.XsPollInfo;
import java.util.List;

/**
 * Main entry point.
 *
 * @author hoschi
 */
public class MainEntryPoint implements EntryPoint {

	private PollServiceGwtAsync service = (PollServiceGwtAsync) GWT.create(PollServiceGwt.class);
	private Label label;

	/**
	 * Creates a new instance of MainEntryPoint
	 */
	public MainEntryPoint() {
	}

	/**
	 * The entry point method, called automatically by loading a module
	 * that declares an implementing class as an entry-point
	 */
	public void onModuleLoad() {

		label = new Label("teeeeeeest");
		final Button button = new Button("Click me!");

		button.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				sendFooString("blubb");

			}
		});

		RootPanel.get().add(button);
		RootPanel.get().add(label);
	}

	void sendFooString(String s) {
		service.myMethod(s, new AsyncCallback<List<xoPoll>>() {

			public void onFailure(Throwable caught) {
				Window.alert("RPC to sendEmail() failed.");
			}

			public void onSuccess(List<xoPoll> result) {
				if (result.size() > 0) {
					xoPoll poll = result.get(0);
					label.setText(poll.getTitle());

				}
			}
		});
	}
}
