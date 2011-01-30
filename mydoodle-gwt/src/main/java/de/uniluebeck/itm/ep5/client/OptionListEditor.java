package de.uniluebeck.itm.ep5.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

import de.uniluebeck.itm.ep5.poll.domain.IOption;
import de.uniluebeck.itm.ep5.poll.domain.XODateOption;
import de.uniluebeck.itm.ep5.poll.domain.XOLocalizedString;
import de.uniluebeck.itm.ep5.poll.domain.XOOptionList;
import de.uniluebeck.itm.ep5.poll.domain.XOTextOption;

public class OptionListEditor {
	
	public interface OptionListEditorListener {
		public void onRemoveOptionList(OptionListEditor editor);
	}
	
	private Widget rootWidget;
	private VerticalPanel optionsPanel;
	private boolean textOptions;
	private String title;
	private String optionPrefix;
	private String optionListPrefix;
	private String[] locales;
	
	private Map<Widget, Object> optionMap;
	
	public OptionListEditor(XOOptionList optionList, String[] locales) {
		this(optionList.getTitle(), locales, optionList.getTexts() != null);		
		if (textOptions) {
			for (IOption option : optionList.getTexts()) {
				addTextOption(((XOTextOption) option).getStrings());
			}
		} else {
			for (IOption option : optionList.getDates()) {
				addDateOption(((XODateOption) option).getDate());
			}
		}
	}
	
	public OptionListEditor(String title, boolean textOptions, String[] locales) {
		this(title, locales, textOptions);
	}

	private OptionListEditor(String title, String[] locales, boolean textOptions) {
		this.title = title;
		this.locales = locales;
		this.textOptions = textOptions;
		this.optionListPrefix = "option list: ";
		this.optionPrefix = "option: ";
		
		this.optionMap = new HashMap<Widget, Object>();
		
		VerticalPanel panel = new VerticalPanel();
		rootWidget = panel;
		
		panel.add(createRemoveWidget(rootWidget, optionListPrefix+title));
		
		optionsPanel = new VerticalPanel();
		panel.add(optionsPanel);
		
		panel.add(createAddWidget());
	}
		
	private void addTextOption(List<XOLocalizedString> strings) {
		
		StringBuilder sb = new StringBuilder(optionPrefix);
		for (XOLocalizedString string : strings) {
			sb.append(string.getLocale()).append("='").append(string.getText()).append("' ");
		}
		
		Widget w = createRemoveWidget(null, sb.toString());
		optionsPanel.add(w);
		optionMap.put(w, strings);
	}
	
	private void addDateOption(Date date) {
		Widget w = createRemoveWidget(null, optionPrefix+date.toString());
		optionsPanel.add(w);
		optionMap.put(w, date);
	}
	
	private Widget createAddWidget() {
		final Grid grid = new Grid(1,2);
		
		final Widget box = textOptions?(new LocalizedTextBox(locales)):(new DateBox());
		final Button button = new Button("add option");
		button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent arg0) {
				if (textOptions) {
					LocalizedTextBox textBox = (LocalizedTextBox)box;
					if (!textBox.noStringsSet()) {
						addTextOption(textBox.getLocalizedStrings());
						textBox.resetStrings();
					}
				} else {
					DateBox dateBox = (DateBox)box;
					if (dateBox.getValue() != null) {
						addDateOption(dateBox.getValue());
						dateBox.setValue(null);
					}
				}
			}
		});
		
		grid.setWidget(0, 0, box);
		grid.setWidget(0, 1, button);
		
		return grid;
	}
	
	private static Widget createRemoveWidget(final Widget toBeRemoved, String labelText) {
		final Grid grid = new Grid(1,2);
		
		final Label label = new Label(labelText);
		final Button button = new Button("remove");
		button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent arg0) {
				if (toBeRemoved == null) {
					grid.removeFromParent();
				} else {
					toBeRemoved.removeFromParent();
				}
			}
		});
		
		grid.setWidget(0, 0, label);
		grid.setWidget(0, 1, button);
		
		return grid;
	}
	
	private Object getOptionFromRemoveWidget(Widget w) {
		//String text = ((Label)((Grid)w).getWidget(0, 0)).getText();
		//return text.substring(optionPrefix.length());
		return optionMap.get(w);
	}
	
	public Widget getRootWidget() {
		return rootWidget;
	}
	
	@SuppressWarnings("unchecked")
	public XOOptionList getOptionList() {
		XOOptionList result = new XOOptionList();
		result.setTitle(title);
		List<IOption> options = new ArrayList<IOption>();
		
		for (int i = 0; i < optionsPanel.getWidgetCount(); i++) {
			Object optionData = getOptionFromRemoveWidget(optionsPanel.getWidget(i));
			if (textOptions) {
				XOTextOption option = new XOTextOption();
								
				option.setStrings((List<XOLocalizedString>)optionData);
				
				options.add(option);
			} else {
				XODateOption option = new XODateOption();
				option.setDate((Date)optionData);
				
				options.add(option);
			}
		}
		
		if (textOptions) {
			result.setTexts(options);
		} else {
			result.setDates(options);
		}
		
		return result;
	}

}
