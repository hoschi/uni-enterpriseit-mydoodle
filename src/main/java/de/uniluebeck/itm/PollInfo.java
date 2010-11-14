package de.uniluebeck.itm;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PollInfo implements IPollInfo {
	
	private int id;
	
	private Map<Locale,String> nameMap = new HashMap<Locale,String>();
	
	public PollInfo() {
		
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getName(Locale locale) {
		return nameMap.get(locale);
	}

}
