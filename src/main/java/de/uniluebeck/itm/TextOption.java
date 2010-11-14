package de.uniluebeck.itm;

import java.util.HashMap;
import java.util.Locale;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class TextOption implements IOption {
	
	private HashMap<Locale,String> textMap;
	
	public TextOption() {
		
	}

	@WebMethod()
	public String getValue(Locale locale) {
		return textMap.get(locale);
	}

	public void setValue(Locale locale, String value) {
		textMap.put(locale, value);
	}

}
