package de.uniluebeck.itm;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlRootElement;

@WebService()
@XmlRootElement
public interface IPollSystem {
	
	@WebMethod()
	public List<IPollInfo> getPolls();
	
	@WebMethod()
	public IPoll getPoll(@WebParam(name="id") int id);

}
