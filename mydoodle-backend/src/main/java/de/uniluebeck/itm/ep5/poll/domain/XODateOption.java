package de.uniluebeck.itm.ep5.poll.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XODateOption implements IOption {

    private String id;
	private Date date;
    private XOOptionList list;
    private List<String> votes;
	

    public XODateOption() {
        this.setVotes(new ArrayList<String>());
    }

	public XODateOption(Date date) {
        this.setVotes(new ArrayList<String>());
		this.date = date;
    }

    public Date getDate() {
        return date;
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

	/**
	 * @param date the date to set
	 */ public void setDate(Date date) {
		this.date = date;
	}
}
