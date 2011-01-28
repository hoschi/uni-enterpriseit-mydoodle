/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import java.util.List;

/**
 * Main entry point.
 *
 * @author hoschi
 */
public class MainEntryPoint implements EntryPoint {

	private PollServiceGwtAsync service = (PollServiceGwtAsync) GWT.create(PollServiceGwt.class);
	private Panel showPollListPanel;
	private Panel addPollPanel;
	private Panel myRootPanel;
	private Button addOptionListButton;
	private Button validateAndSaveNewPollButton;
	private TextBox otherHostUrl;
	private TextBox otherHostLocale;

	/**
	 * Creates a new instance of MainEntryPoint
	 */
	public MainEntryPoint() {
		addPollPanel = new VerticalPanel();
		showPollListPanel = new VerticalPanel();
		myRootPanel = new VerticalPanel();
	}

	/**
	 * The entry point method, called automatically by loading a module
	 * that declares an implementing class as an entry-point
	 */
	public void onModuleLoad() {
		createAddPollForm();
		createPollList();

		myRootPanel.addStyleName("main");
		RootPanel.get().add(myRootPanel);
		myRootPanel.add(showPollListPanel);
		myRootPanel.add(addPollPanel);
	}

	private void createAddPollForm() {
		addPollPanel.clear();
		Grid grid = new Grid(1, 2);

		addPollPanel.add(new InlineHTML("<h1>Add a new one</h1>"));

		grid.setWidget(0, 0, new Label("title"));
		grid.setWidget(0, 1, new TextBox());
		addPollPanel.add(grid);

		addEmptyRow(addPollPanel);

		addOptionListButton = new Button("add an option list");
		addOptionListButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				addOptionList();
			}
		});
		addPollPanel.add(addOptionListButton);

		addEmptyRow(addPollPanel);

		validateAndSaveNewPollButton = new Button("save");
		validateAndSaveNewPollButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				validateAndSaveNewPoll();
			}
		});
		addPollPanel.add(validateAndSaveNewPollButton);

	}

	private void addOptionList() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	private void validateAndSaveNewPoll() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	private void createPollList() {
		showPollListPanel.add(new InlineHTML("<h1>Poll List</h1>"));
		// add more lists
		showPollListPanel.add(new InlineHTML("<h2>Add polls from other host</h2>"));
		otherHostUrl = new TextBox();
		otherHostLocale = new TextBox();
		Button button = new Button("add");
		button.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				throw new UnsupportedOperationException("Not supported yet.");
			}
		});


		Panel addStuff = new HorizontalPanel();
		addStuff.add(new Label("url: "));
		addStuff.add(otherHostUrl);
		addStuff.add(new Label("locale: "));
		addStuff.add(otherHostLocale);
		addStuff.add(button);
		showPollListPanel.add(addStuff);

		// localhost polls
		createPollList("http://localhost:8080/poll?WSDL", "en");
	}

	private void createPollList(String url, String locale) {
		final String myUrl = url;
		final String myLocale = locale;
		service.getPollTitles(new AsyncCallback<List<String>>() {

			public void onFailure(Throwable caught) {
				Window.alert("RPC to getPollTitles() failed.");
			}

			public void onSuccess(List<String> result) {
				Panel panel = new VerticalPanel();
				panel.add(new InlineHTML("<h2>List from " + myUrl + " (" + myLocale + ")</h2>"));

				for (String titel : result) {
					Panel item = new HorizontalPanel();

					Label label = new Label(titel);
					item.add(label);
					item.add(new Button("show"));

					panel.add(item);
				}
				// add status line
				addEmptyRow(panel);
				panel.add(new Label("fetched " + result.size() + " polls"));
				addEmptyRow(panel);

				// control buttons for list
				Panel bottom = new HorizontalPanel();
				Button updateButton = new Button("update data");
				Button removeButton = new Button("remove list");
				removeButton.addClickHandler(new ClickHandler() {

					public void onClick(ClickEvent event) {
						Element element = event.getRelativeElement();
						Element pollList = element.getParentElement().getParentElement().getParentElement().getParentElement().getParentElement().getParentElement().getParentElement().getParentElement().getParentElement().getParentElement();
						pollList.getParentElement().removeChild(pollList);
					}
				});
				bottom.add(updateButton);
				bottom.add(removeButton);
				panel.add(bottom);
				showPollListPanel.add(panel);
			}
		});
	}

	private void addEmptyRow(Panel panel) {
		panel.add(new InlineHTML("<br/>"));
	}
}
