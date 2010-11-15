package de.uniluebeck.itm;

import java.util.Locale;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(AnyTypeAdapter.class) 
public interface IPollInfo {
	
	public String getName(@WebParam(name="locale") Locale locale);
	
	public int getId();

}
