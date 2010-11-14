package de.uniluebeck.itm;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public interface IPollSystem {
	
	@WebMethod()
	public List<IPollInfo> getPolls();
	
	@WebMethod()
	public IPoll getPoll(int id);

}
