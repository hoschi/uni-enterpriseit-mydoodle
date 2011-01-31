/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import de.uniluebeck.itm.ep5.poll.domain.IOption;
import de.uniluebeck.itm.ep5.poll.domain.XODateOption;
import de.uniluebeck.itm.ep5.poll.domain.XOOptionList;
import de.uniluebeck.itm.ep5.poll.domain.XOTextOption;
import de.uniluebeck.itm.ep5.poll.domain.xoPoll;

/**
 * Main entry point.
 *
 * @author hoschi
 */
public class MainEntryPoint implements EntryPoint {

	private PollServiceGwtAsync service = (PollServiceGwtAsync) GWT.create(
			PollServiceGwt.class);
	public static final String localhostWsdl =
			"http://localhost:8080/poll?WSDL";
	private Panel showPollListPanel;
	private Panel addPollPanel;
	private Panel myRootPanel;
	private Button validateAndSaveNewPollButton;
	private TextBox username;
	private String currentLocale;
	private LocaleSettings localeSettings;
	private PollEditor pollEditor;

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
	@Override
	public void onModuleLoad() {
		this.currentLocale = LocaleInfo.getCurrentLocale().
				getLocaleName();
		
		localeSettings = new LocaleSettings(LocaleInfo.getAvailableLocaleNames(), 
				indexOf(LocaleInfo.getAvailableLocaleNames(), this.currentLocale));
		
		createAddPollForm();
		createPollList();

		myRootPanel.addStyleName("main");
		RootPanel.get().add(myRootPanel);
		myRootPanel.add(showPollListPanel);
		myRootPanel.add(addPollPanel);
	}

	private static int indexOf(String[] strings, String arg) {
		for (int i = 0; i < strings.length; i++) {
			if (arg.equals(strings[i])) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * create the "add new poll" form
	 */
	private void createAddPollForm() {
		addPollPanel.clear();

		addPollPanel.add(new InlineHTML("<h1>Add a new one</h1>"));

		pollEditor = new PollEditor(localeSettings);
		addPollPanel.add(pollEditor.getRootWidget());
		
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
	
	/*
	 * save a new poll with the form data
	 */
	private void saveNewPoll() {
		/*
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

		xoPoll poll = new xoPoll();
		poll.setEndDate(endDateBox.getValue());
		poll.setPublic(isPublicBox.getValue());
		poll.setStartDate(startDateBox.getValue());
		poll.setTitle(titleBox.getValue());
		*/
		
		xoPoll poll = pollEditor.getPoll();

		this.service.addPoll(poll, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("RPC to addPoll() failed: " + caught.
						getLocalizedMessage());
			}

			@Override
			public void onSuccess(Void result) {
				//createAddPollForm();
			}
		});

	}

	/*
	 * create main poll list
	 */
	private void createPollList() {
		showPollListPanel.add(new InlineHTML("<h1>Poll List</h1>"));
		// add current locale
		Panel localepanel = new HorizontalPanel();
		localepanel.add(new Label("current locale: "));
		localepanel.add(new Label(this.currentLocale));
		showPollListPanel.add(localepanel);

		// add username box
		this.username = new TextBox();
		Panel userpanel = new HorizontalPanel();
		userpanel.add(new Label("username: "));
		userpanel.add(this.username);
		showPollListPanel.add(userpanel);

		// add more lists
		showPollListPanel.add(new InlineHTML(
				"<h2>Add polls from other host</h2> (leave empty for localhost)"));
		final TextBox otherHostUrl = new TextBox();
		otherHostUrl.setWidth("400px");
		final TextBox otherHostLocale = new TextBox();
		otherHostLocale.setWidth("50px");
		otherHostLocale.setText(this.currentLocale);
		Button button = new Button("add");
		button.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (otherHostLocale.getText().isEmpty())
					Window.alert("you must give a locale");
				
				if (otherHostUrl.getText().isEmpty())
					createLocalPollList(otherHostLocale.getText());
				else
					createPollList(otherHostUrl.getText(), otherHostLocale.getText());
			}
		});


		Panel addStuff = new HorizontalPanel();
		addStuff.add(new Label("url: "));
		addStuff.add(otherHostUrl);
		addStuff.add(new Label("locale: "));
		addStuff.add(otherHostLocale);
		addStuff.add(button);
		showPollListPanel.add(addStuff);

		// localhost polls with rmi service
		createLocalPollList(this.currentLocale);
		// localhost polls with web service
		createPollList(localhostWsdl, this.currentLocale);

	}

	/*
	 * create a poll list with data, fetched from server
	 * @url url to WSDL from other server
	 * @locale string which represents a locale of the server
	 */
	private void createLocalPollList(final String locale) {
		service.getLocalPollTitles(new AsyncCallback<List<xoPoll>>() {

			public void onFailure(Throwable caught) {
				Window.alert("RPC to getPollTitles() failed.");
			}

			public void onSuccess(List<xoPoll> result) {
				createPollList(result, "local server", localhostWsdl, locale,
						true);
			}
		});
	}

	/*
	 * create a poll list with data, fetched from server
	 * @url url to WSDL from other server
	 * @locale string which represents a locale of the server
	 */
	private void createPollList(final String url, final String locale) {
		service.getPollTitles(url, locale, new AsyncCallback<List<xoPoll>>() {

			public void onFailure(Throwable caught) {
				Window.alert("RPC to getPollTitles() failed.");
			}

			public void onSuccess(List<xoPoll> result) {
				createPollList(result, url, url, locale, false);
			}
		});
	}

	private void createPollList(final List<xoPoll> polls, final String title,
			final String url, final String locale, final boolean local) {
		Panel panel = new VerticalPanel();
		final DecoratorPanel decorator =
				new DecoratorPanel();
		decorator.setWidget(panel);
		panel.add(new InlineHTML("<h2>List from <a href=\"" + url +
				"\">" + title + "</a> (" + locale + ")</h2>"));
		for (xoPoll poll : polls) {
			final xoPoll pollFinal = poll;
			Panel item =
					new HorizontalPanel();
			final Panel showPanel =
					new VerticalPanel();
			Label label =
					new Label(poll.getTitle());
			item.add(label);
			Button showButton =
					new Button("show/refresh");
			showButton.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					if (local) {
						fetchPoll(showPanel, pollFinal, locale);
					} else {
						fetchPoll(showPanel, pollFinal, url, locale);
					}
				}
			});
			item.add(showButton);
			panel.add(item);
			panel.add(showPanel);
		}
		// add status line
		addEmptyRow(panel);
		panel.add(new Label("fetched " + polls.size() + " polls"));
		addEmptyRow(panel);
		// control buttons for list
		Panel bottom =
				new HorizontalPanel();
		Button updateButton =
				new Button("update");
		updateButton.addClickHandler(new ClickHandler() {

			DecoratorPanel pollPanel = decorator;

			public void onClick(ClickEvent event) {
				showPollListPanel.remove(this.pollPanel);
				if (local) {
					// localhost polls with rmi service
					createLocalPollList(locale);
				} else {
					// localhost polls with web service
					createPollList(url, locale);
				}
			}
		});
		Button removeButton =
				new Button("remove");
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

	/*
	 * fetch details of a partially loaded poll
	 */
	private void fetchPoll(final Panel mainPanel, xoPoll pollInfo,
			final String url, final String locale) {

		service.getPoll(url, locale, pollInfo.getId(), new AsyncCallback<xoPoll>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("RPC failure in showPoll");
			}

			@Override
			public void onSuccess(xoPoll poll) {
				showPoll(poll, mainPanel, url, locale);
			}
		});


	}

	/*
	 * fetch details of a partially loaded poll
	 */
	private void fetchPoll(final Panel mainPanel, xoPoll pollInfo,
			final String locale) {
		service.getLocalPoll(pollInfo.getId(), new AsyncCallback<xoPoll>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("RPC failure in showPoll");
			}

			@Override
			public void onSuccess(xoPoll poll) {
				showPoll(poll, mainPanel, localhostWsdl, locale);
			}
		});
	}

	private void showPoll(xoPoll poll, Panel panel, String url, String locale) {
		panel.clear();
		String privateString = "";
		if (!poll.isPublic()) {
			privateString += "is private";
		}
		panel.add(new Label(privateString));
		String dates = "";
		if (poll.getStartDate() != null) {
			dates =
					"start date is: " +
					DateTimeFormat.getShortDateFormat().
					format(poll.getStartDate()) + ". ";
			panel.add(new Label(dates));
		}
		if (poll.getEndDate() != null) {
			dates =
					"end date is: " +
					DateTimeFormat.getShortDateFormat().
					format(poll.getEndDate()) + ".";
			panel.add(new Label(dates));
		}
		panel.add(buildPollGrid(poll, url, locale));
		addEmptyRow(panel);
	}

	private Widget buildPollGrid(xoPoll poll, final String url,
			final String locale) {
		FlexTable t = new FlexTable();
		t.setStylePrimaryName("pollgrid");
		Set votersSet = new HashSet();


		if (!username.getText().isEmpty()) {
			votersSet.add(username.getText());
		}

		if (poll != null) {
			// create headers
			int optionListCounter = 1;
			for (XOOptionList optionList : poll.getOptionLists()) {
				t.setText(0, optionListCounter, optionList.getTitle());
				int optionCounter = 0;
				for (IOption option : optionList.getOptions()) {
					XOTextOption text;
					XODateOption date;

					int column;

					// if this is the first entry there is no row 1, so
					// getCellCount(1) throws out of bounds exception
					if (t.getRowCount() == 1) {
						column = 1;
					} else {
						column = t.getCellCount(1);
					}

					// make entry
					if (option instanceof XOTextOption) {
						text = (XOTextOption) option;
						t.setText(1, column, text.getStringByLocale(locale));

					} else if (option instanceof XODateOption) {
						date = (XODateOption) option;
						t.setText(1, column, DateTimeFormat.
								getLongDateTimeFormat().
								format(date.getDate()));

					} else {
						throw new RuntimeException("unknown option type");
					}

					// add voters to hash set
					for (String voter : option.getVotes()) {
						votersSet.add(voter);
					}
					optionCounter++;
				}


				t.getFlexCellFormatter().setColSpan(0, optionListCounter,
						optionCounter);
				optionListCounter++;
			}
			// create checkboxes
			if (poll.getOptionLists().size() > 0) {
				// calculate if poll is active or not
				Date now = new Date();
				boolean active;
				if (poll.getStartDate() == null && poll.getEndDate() ==
						null) {
					active = true;
				} else if (poll.getStartDate() != null && poll.getEndDate() !=
						null && poll.getStartDate().before(now) && poll.
						getEndDate().after(now)) {
					active = true;
				} else if (poll.getStartDate() != null && poll.getEndDate() ==
						null && poll.getStartDate().before(
						now)) {
					active = true;
				} else if (poll.getEndDate() != null && poll.getStartDate() ==
						null && poll.getEndDate().after(now)) {
					active = true;
				} else {
					active = false;
				}

				// create checkboxes
				final List<VoteBox> saveableBoxes = new ArrayList<VoteBox>();
				Iterator iter = votersSet.iterator();
				int row = 2;
				while (iter.hasNext()) {
					String voter = (String) iter.next();
					t.setWidget(row, 0, new Label(voter));

					// create checkboxes
					for (XOOptionList optionList : poll.getOptionLists()) {
						for (IOption option : optionList.getOptions()) {
							int column = t.getCellCount(row);
							VoteBox box = new VoteBox();

							box.setOptionId(option.getId());
							box.setValue(Boolean.FALSE);
							box.setEnabled(false);
							if (option.getVotes().contains(voter)) {
								// add a checked checkbox
								box.setValue(Boolean.TRUE);
							}
							if (active && voter.equals(username.getText())) {
								// current user can delete his votes
								box.setEnabled(true);
								saveableBoxes.add(box);
							}
							t.setWidget(row, column, box);
						}
					}

					// add save button
					if (active && voter.equals(username.getText())) {
						Button saveVotesButton = new Button("save");
						saveVotesButton.addClickHandler(new ClickHandler() {

							@Override
							public void onClick(ClickEvent event) {
								saveVotes(saveableBoxes, url);
							}
						});
						t.setWidget(row, t.getCellCount(row), saveVotesButton);
					}
					row++;
				}
			}
		}
		return t;
	}

	private void saveVotes(List<VoteBox> boxes,
			String url) {
		List<String> ids = new ArrayList<String>();
		for (VoteBox box : boxes) {
			if (box.getValue()) {
				ids.add(box.getOptionId());
			}
		}
		service.voteForOptions(url, ids, username.getText(), new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("error on RPC call in saveVotes");
				;
			}

			@Override
			public void onSuccess(Void result) {
				Window.alert("saved");
			}
		});
	}
	/*
	 * add a empty row to a panel for styling issues
	 */

	private void addEmptyRow(Panel panel) {
		panel.add(new InlineHTML("<br/>"));
	}
}
