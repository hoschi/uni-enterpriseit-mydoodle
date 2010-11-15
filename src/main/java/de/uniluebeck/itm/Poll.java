package de.uniluebeck.itm;

import java.util.List;

import javax.jws.WebService;

public class Poll implements IPoll {
	
	private IPollInfo info;
	
	private boolean isPublic;

	private List<OptionList> optionLists;
	
	public Poll() {
		
	}
	
	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public IPollInfo getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OptionList> getOptionLists() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
