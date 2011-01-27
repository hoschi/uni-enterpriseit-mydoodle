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
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
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
	private Panel pollPanel;

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

		pollPanel = new VerticalPanel();
		label = new Label("test");
		pollPanel.add(label);

		final Button button = new Button("Click me!");

		button.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				sendFooString("blubb");

			}
		});

		RootPanel.get().add(button);
		RootPanel.get().add(pollPanel);
	}

	void sendFooString(String s) {
		service.getPollTitles( new AsyncCallback<List<String>>() {

			public void onFailure(Throwable caught) {
				Window.alert("RPC to sendEmail() failed.");
			}

			public void onSuccess(List<String> result) {
				pollPanel.clear();
				for (String titel : result) {
					Label label = new Label(titel);
					pollPanel.add(label);
				}
				pollPanel.add(new Label("fetched " + result.size() + " polls"));
			}
		});
	}
}
