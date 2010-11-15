package de.uniluebeck.itm;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(AnyTypeAdapter.class) 
public interface IPoll {
	
	public IPollInfo getInfo();
	
	public List<OptionList> getOptionLists();
	
}
