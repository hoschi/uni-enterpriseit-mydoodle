package de.uniluebeck.itm;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class Vote {
	
	private String voterName;
	
	private IOption option;
	
	public Vote() {
		
	}

	@WebMethod()
	public String getVoterName() {
		return voterName;
	}

	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}

	@WebMethod()
	public IOption getOption() {
		return option;
	}

	public void setOption(IOption option) {
		this.option = option;
	}

}
