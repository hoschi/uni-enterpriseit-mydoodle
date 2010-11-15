package de.uniluebeck.itm;

import javax.xml.bind.annotation.XmlElement;


public class Poll {
	
	private PollInfo info;
	private boolean isPublic;
	private OptionList[] optionLists;
	
	public Poll() {
		
	}
	
	@XmlElement
	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	@XmlElement
	public PollInfo getInfo() {
		// TODO Auto-generated method stub
		return this.info;
	}
	
	@XmlElement
	public OptionList[] getOptionLists() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
