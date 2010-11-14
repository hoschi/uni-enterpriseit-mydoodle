package de.uniluebeck.itm;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class DateOption implements IOption {
	
	private Date value;
	
	public DateOption() {
		
	}

	@WebMethod()
	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}

}
