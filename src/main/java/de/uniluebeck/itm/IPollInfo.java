package de.uniluebeck.itm;

import java.util.Locale;

import javax.jws.WebMethod;
import javax.jws.WebService;

public interface IPollInfo {
	
	public String getName(Locale locale);
	
	public int getId();

}
