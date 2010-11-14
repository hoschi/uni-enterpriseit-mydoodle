package de.uniluebeck.itm;

import java.util.Locale;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public interface IPollInfo {
	
	@WebMethod()
	public String getName(Locale locale);
	
	@WebMethod()
	public int getId();

}
