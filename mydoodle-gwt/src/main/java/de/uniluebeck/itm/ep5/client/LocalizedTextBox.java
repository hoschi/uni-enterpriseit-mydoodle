package de.uniluebeck.itm.ep5.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

import de.uniluebeck.itm.ep5.poll.domain.XOLocalizedString;

public class LocalizedTextBox extends Grid {
	
	private String[] locales;
	private String[] localizedTexts;
	private TextBox textBox;
	
	public LocalizedTextBox(String[] locales) {
		super(1,2);
		this.localizedTexts = new String[locales.length];
		
		Grid grid = this;
		
		final TextBox text = new TextBox();
		textBox = text;
		grid.setWidget(0, 1, text);
		
		final ListBox list = new ListBox();
		for (int i = 0; i < locales.length; i++) {
			localizedTexts[i] = "";
			list.addItem(locales[i]);
		}
		grid.setWidget(0, 0, list);
		

		list.addChangeHandler(new ChangeHandler(){
			@Override
			public void onChange(ChangeEvent arg0) {
				text.setText(localizedTexts[list.getSelectedIndex()]);
			}
		});
		
		text.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				localizedTexts[list.getSelectedIndex()] = text.getText();
			}
		});
	}
	
	public int getLocaleCount() {
		return locales.length;
	}
	
	public String getLocale(int i) {
		return locales[i];
	}
	
	public String getLocalizedText(int i) {
		return localizedTexts[i];
	}
	
	public List<XOLocalizedString> getLocalizedStrings() {
		List<XOLocalizedString> result = new ArrayList<XOLocalizedString>();
		for (int i = 0; i < locales.length; i++) {
			result.add(new XOLocalizedString(localizedTexts[i], locales[i]));
		}
		return result;
	}
	
	public boolean noStringsSet() {
		for (String text : localizedTexts) {
			if (!text.equals("")) {
				return false;
			}
		}
		return true;
	}

	public void resetStrings() {
		for (int i = 0; i < locales.length; i++) {
			localizedTexts[i] = "";
		}
		textBox.setText("");
	}

}
