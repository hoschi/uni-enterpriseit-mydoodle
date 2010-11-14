package de.uniluebeck.itm;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class OptionList {
	
	private List<IOption> list;

	@WebMethod()
	public List<IOption> getList() {
		return list;
	}

	public void setList(List<IOption> list) {
		this.list = list;
	}
}
