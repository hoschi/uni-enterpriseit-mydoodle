package de.uniluebeck.itm;

import java.util.List;

public class Poll implements IPoll {
	boolean isPublic;
	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public List<OptionList> getList() {
		return list;
	}

	public void setList(List<OptionList> list) {
		this.list = list;
	}

	List<OptionList> list;

	public List<IPoll> getPolls() {
		// TODO Auto-generated method stub
		return null;
	}

	public IPoll getPoll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
