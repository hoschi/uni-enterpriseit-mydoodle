package de.uniluebeck.itm;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PollInfo {
	
	private int id;
	
	private Map<Locale,String> nameMap = new HashMap<Locale,String>();
	
	public PollInfo() {
		
	}

	public int getId() {
		return id;
	}

	public String getName(Locale locale) {
		return nameMap.get(locale);
	}

}
