package de.uniluebeck.itm;

import java.util.List;

public class Poll implements IPoll {
	
	private IPollInfo info;
	
	private boolean isPublic;

	private List<OptionList> optionLists;
	
	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	@Override
	public IPollInfo getInfo() {
		return info;
	}

	@Override
	public List<OptionList> getOptionLists() {
		return optionLists;
	}

	

}
