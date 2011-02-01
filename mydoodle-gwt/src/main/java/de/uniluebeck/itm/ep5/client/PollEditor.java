package de.uniluebeck.itm.ep5.client;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

import de.uniluebeck.itm.ep5.poll.domain.XOOptionList;
import de.uniluebeck.itm.ep5.poll.domain.xoPoll;

public class PollEditor {
	
	private Widget rootWidget;
	private OptionListsEditor listsEditor;
	private TextBox titleBox;
	private CheckBox isPublicBox;
	private DateBox startDateBox;
	private DateBox endDateBox;
	
	public PollEditor(LocaleSettings ls, xoPoll poll) {
		this(ls, poll.getOptionLists());
		titleBox.setText(poll.getTitle());
		isPublicBox.setValue(poll.isPublic());
		startDateBox.setValue(poll.getStartDate());
		endDateBox.setValue(poll.getEndDate());
	}
	
	public PollEditor(LocaleSettings ls) {
		this(ls, (List<XOOptionList>)null);
	}
	
	private PollEditor(LocaleSettings ls, List<XOOptionList> optionLists) {
		VerticalPanel panel = new VerticalPanel();
		rootWidget = panel;
		
		Grid grid = new Grid(4, 2);
		
		grid.setWidget(0, 0, new Label("title"));
		titleBox = new TextBox();
		grid.setWidget(0, 1, titleBox);

		grid.setWidget(1, 0, new Label("is public"));
		isPublicBox = new CheckBox();
		isPublicBox.setValue(Boolean.TRUE);
		grid.setWidget(1, 1, isPublicBox);

		grid.setWidget(2, 0, new Label("start date"));
		startDateBox = new DateBox();
		grid.setWidget(2, 1, startDateBox);

		grid.setWidget(3, 0, new Label("end date"));
		endDateBox = new DateBox();
		grid.setWidget(3, 1, endDateBox);
		
		panel.add(grid);
		
		if (optionLists == null)
			listsEditor = new OptionListsEditor(ls);
		else
			listsEditor = new OptionListsEditor(ls, optionLists);
		panel.add(listsEditor.getRootWidget());
	}
	
	public void setPoll(xoPoll poll) {
		clearInputs();
		titleBox.setText(poll.getTitle());
		isPublicBox.setValue(poll.isPublic());
		startDateBox.setValue(poll.getStartDate());
		endDateBox.setValue(poll.getEndDate());
		listsEditor.setOptionLists(poll.getOptionLists());
	}
	
	public xoPoll getPoll() {
		xoPoll result = new xoPoll();
		
		String title = titleBox.getText();
		boolean isPublic = isPublicBox.getValue();
		Date startDate = startDateBox.getValue();
		Date endDate = endDateBox.getValue();
		List<XOOptionList> optionLists = listsEditor.getOptionLists();
		
		result.setTitle(title);
		result.setPublic(isPublic);
		result.setStartDate(startDate);
		result.setEndDate(endDate);
		result.setOptions(optionLists);
		
		return result;
	}
	
	public void clearInputs() {
		titleBox.setText("");
		isPublicBox.setValue(true);
		startDateBox.setValue(null);
		endDateBox.setValue(null);
		listsEditor.clearInputs();
	}
	
	public Widget getRootWidget() {
		return rootWidget;
	}

}
