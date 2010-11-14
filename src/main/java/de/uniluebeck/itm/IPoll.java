package de.uniluebeck.itm;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public interface IPoll {
	
	@WebMethod()
	public IPollInfo getInfo();
	
	@WebMethod()
	public List<OptionList> getOptionLists();
	
}
