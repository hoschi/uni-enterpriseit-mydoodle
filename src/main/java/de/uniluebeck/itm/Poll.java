package de.uniluebeck.itm;


public class Poll {
	
	private PollInfo info;
	
	private boolean isPublic;

	private OptionList[] optionLists;
	
	public Poll() {
		
	}
	
	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public PollInfo getInfo() {
		// TODO Auto-generated method stub
		return this.info;
	}

	public OptionList[] getOptionLists() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
