package de.uniluebeck.itm;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

public interface IPoll {
	
	public IPollInfo getInfo();
	
	public List<OptionList> getOptionLists();
	
}
