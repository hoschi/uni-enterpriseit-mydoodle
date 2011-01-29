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
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import de.uniluebeck.itm.ep5.gwt.GwtPoll;
import java.util.Date;
import java.util.List;

/**
 * Main entry point.
 *
 * @author hoschi
 */
public class MainEntryPoint implements EntryPoint {

	private PollServiceGwtAsync service = (PollServiceGwtAsync) GWT.create(
			PollServiceGwt.class);
	private Panel showPollListPanel;
	private Panel addPollPanel;
	private Panel myRootPanel;
	private Button addOptionListButton;
	private Button validateAndSaveNewPollButton;
	private TextBox otherHostUrl;
	private TextBox otherHostLocale;
	private Grid addPollFormGrid;

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
		addPollFormGrid = new Grid(4, 2);

		addPollPanel.add(new InlineHTML("<h1>Add a new one</h1>"));

		addPollFormGrid.setWidget(0, 0, new Label("title"));
		TextBox titleBox = new TextBox();
		addPollFormGrid.setWidget(0, 1, titleBox);

		addPollFormGrid.setWidget(1, 0, new Label("is public"));
		CheckBox isPublicBox = new CheckBox();
		isPublicBox.setValue(Boolean.TRUE);
		addPollFormGrid.setWidget(1, 1, isPublicBox);

		addPollFormGrid.setWidget(2, 0, new Label("start date"));
		DateBox startDateBox = new DateBox();
		addPollFormGrid.setWidget(2, 1, startDateBox);

		addPollFormGrid.setWidget(3, 0, new Label("end date"));
		DateBox endDateBox = new DateBox();
		addPollFormGrid.setWidget(3, 1, endDateBox);

		addPollPanel.add(addPollFormGrid);

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
				saveNewPoll();
			}
		});
		addPollPanel.add(validateAndSaveNewPollButton);

	}

	private void addOptionList() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	private void saveNewPoll() {
		TextBox titleBox =
				(TextBox) addPollFormGrid.getWidget(0, 1);
		CheckBox isPublicBox =
				(CheckBox) addPollFormGrid.getWidget(1, 1);
		DateBox startDateBox =
				(DateBox) addPollFormGrid.getWidget(2, 1);
		DateBox endDateBox =
				(DateBox) addPollFormGrid.getWidget(3, 1);

		// check null
		if (titleBox == null || isPublicBox == null || startDateBox == null || endDateBox ==
				null) {
			throw new RuntimeException("widget is null");
		}

		// validate
		if (titleBox.getValue() == null || titleBox.getValue().equals("")) {
			Window.alert("title can't be empty");
			return;
		}

		GwtPoll poll = new GwtPoll();
		poll.setEndDate(endDateBox.getValue());
		poll.setIsPublic(isPublicBox.getValue());
		poll.setStartDate(startDateBox.getValue());
		poll.setTitle(titleBox.getValue());

		this.service.addPoll(poll, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("RPC to addPoll() failed: " + caught.
						getLocalizedMessage());
			}

			@Override
			public void onSuccess(Void result) {
				createAddPollForm();
			}
		});

	}

	private void createPollList() {
		showPollListPanel.add(new InlineHTML("<h1>Poll List</h1>"));
		// add more lists
		showPollListPanel.add(new InlineHTML(
				"<h2>Add polls from other host</h2>"));
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
		service.getPollTitles(new AsyncCallback<List<GwtPoll>>() {

			public void onFailure(Throwable caught) {
				Window.alert("RPC to getPollTitles() failed.");
			}

			public void onSuccess(List<GwtPoll> result) {
				Panel panel = new VerticalPanel();
				final DecoratorPanel decorator = new DecoratorPanel();
				decorator.setWidget(panel);

				panel.add(new InlineHTML("<h2>List from <a href=\"" + myUrl +
						"\">" + myUrl + "</a> (" + myLocale + ")</h2>"));

				for (GwtPoll poll : result) {
					Panel item = new HorizontalPanel();
					final Panel showPanel = new VerticalPanel();

					Label label = new Label(poll.getTitle());
					item.add(label);
					Button showButton = new Button("show");
					showButton.addClickHandler(new ClickHandler() {
						Panel panel = showPanel;

						@Override
						public void onClick(ClickEvent event) {
							this.panel.add(new Label("test"));
						}
					});
					item.add(showButton);
					item.add(new Button("delete"));

					panel.add(item);
					panel.add(showPanel);
				}
				// add status line
				addEmptyRow(panel);
				panel.add(new Label("fetched " + result.size() + " polls"));
				addEmptyRow(panel);

				// control buttons for list
				Panel bottom = new HorizontalPanel();
				Button updateButton = new Button("update");
				Button removeButton = new Button("remove");
				removeButton.addClickHandler(new ClickHandler() {
					DecoratorPanel pollPanel = decorator;

					public void onClick(ClickEvent event) {
						showPollListPanel.remove(this.pollPanel);
					}
				});
				bottom.add(updateButton);
				bottom.add(removeButton);
				panel.add(bottom);
				
				
				showPollListPanel.add(decorator);
			}
		});
	}

	private void addEmptyRow(Panel panel) {
		panel.add(new InlineHTML("<br/>"));
	}
}
