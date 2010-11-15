package de.uniluebeck.itm;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@WebService()
@XmlJavaTypeAdapter(AnyTypeAdapter.class) 
public class OptionList {
	
	private IOption[] list;
	
	public OptionList() {
		
	}

	@WebMethod()
	public IOption[] getList() {
		return list;
	}

	public void setList(IOption[] list) {
		this.list = list;
	}
}
