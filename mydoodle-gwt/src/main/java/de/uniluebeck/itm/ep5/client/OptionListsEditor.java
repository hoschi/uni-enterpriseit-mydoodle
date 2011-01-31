package de.uniluebeck.itm.ep5.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import de.uniluebeck.itm.ep5.poll.domain.XOOptionList;

public class OptionListsEditor {
	
	private Widget rootWidget;
	private VerticalPanel optionListsPanel;
	private LocaleSettings ls;
	
	private Map<Widget, OptionListEditor> optionListMap;
	
	public OptionListsEditor(final LocaleSettings ls, List<XOOptionList> optionLists) {
		this(ls);
		for (XOOptionList optionList : optionLists) {
			addOptionList(new OptionListEditor(optionList, ls));
		}
	}
	
	public OptionListsEditor(final LocaleSettings ls) {
		this.optionListMap = new HashMap<Widget, OptionListEditor>();
		this.ls = ls;
		
		VerticalPanel panel = new VerticalPanel();
		rootWidget = panel;
		optionListsPanel = new VerticalPanel();
		panel.add(optionListsPanel);
		
		Grid grid = new Grid(2,2);
		Label label = new Label("option list name");
		grid.setWidget(0, 0, label);
		
		final TextBox textBox = new TextBox();
		grid.setWidget(0, 1, textBox);
		
		VerticalPanel radioPanel = new VerticalPanel();
		RadioButton datesButton = new RadioButton("dateTextRadioGroup", "dates");
		final RadioButton stringsButton = new RadioButton("dateTextRadioGroup", "strings");
		stringsButton.setChecked(true);
		radioPanel.add(stringsButton);
		radioPanel.add(datesButton);
		grid.setWidget(1, 0, radioPanel);
		
		Button addButton = new Button("add option list");
		grid.setWidget(1, 1, addButton);
		
		addButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent arg0) {
				boolean textOptions = stringsButton.isChecked();
				String title = textBox.getText();
				
				if (!(title.equals(""))) {
					addOptionList(new OptionListEditor(title, textOptions, ls));
					textBox.setText("");
				}
			}
		});
		
		panel.add(grid);
	}
	
	private void addOptionList(OptionListEditor editor) {
		optionListsPanel.add(editor.getRootWidget());
		optionListMap.put(editor.getRootWidget(), editor);
	}
		
	public Widget getRootWidget() {
		return rootWidget;
	}
	
	public List<XOOptionList> getOptionLists() {
		List<XOOptionList> result = new ArrayList<XOOptionList>();
		for (int i = 0; i < optionListsPanel.getWidgetCount(); i++) {
			result.add(optionListMap.get(optionListsPanel.getWidget(i)).getOptionList());
		}
		return result;
	}

	public void clearInputs() {
		List<Widget> removeList = new ArrayList<Widget>();
		for (int i = 0; i < optionListsPanel.getWidgetCount(); i++) {
			removeList.add(optionListsPanel.getWidget(i));
		}
		for (Widget w : removeList) {
			w.removeFromParent();
		}
		optionListMap.clear();
	}

	public void setOptionLists(List<XOOptionList> optionLists) {
		clearInputs();
		for (XOOptionList optionList : optionLists) {
			addOptionList(new OptionListEditor(optionList, ls));
		}
	}

}
