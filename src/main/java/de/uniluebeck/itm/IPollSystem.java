package de.uniluebeck.itm;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@WebService()
public interface IPollSystem {
	
	@WebMethod()
	public PollInfo[] getPolls();
	
	@WebMethod()
	public Poll getPoll(@WebParam(name="id") int id);

}
