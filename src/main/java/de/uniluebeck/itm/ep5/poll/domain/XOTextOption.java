package de.uniluebeck.itm.ep5.poll.domain;

import java.util.ArrayList;
import java.util.List;

public class XOTextOption implements IOption {
    private String id;
    private XOOptionList list;
    private List<XOLocalizedString> strings;
    private List<String> votes;

    public XOTextOption() {
        this.strings = new ArrayList<XOLocalizedString>();
        this.setVotes(new ArrayList<String>());
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the list
     */
    public XOOptionList getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(XOOptionList list) {
        this.list = list;
    }

    /**
     * @return the strings
     */
    public List<XOLocalizedString> getStrings() {
        return strings;
    }

    /**
     * @param strings the strings to set
     */
    public void setStrings(List<XOLocalizedString> strings) {
        this.strings = strings;
    }

    public void addString(String text, String locale) {
        XOLocalizedString s = new XOLocalizedString(text, locale);
        this.strings.add(s);
    }

	/**
	 * @param votes the votes to set
	 */
	public void setVotes(List<String> votes) {
		this.votes = votes;
	}

	/**
	 * @return the votes
	 */
	public List<String> getVotes() {
		return votes;
	}

	public void addVote(String voter) {
		this.votes.add(voter);
	}
	
	public void removeVote(String voter) {
		this.votes.remove(voter);
	}

	public String getStringByLocale(String languageCode) {
		for (XOLocalizedString lString : this.getStrings()) {
			if (lString.getLocale().equals(languageCode))
				return lString.getText();
		}
		return null;
	}

}

