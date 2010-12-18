package de.uniluebeck.itm.ep5.poll.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class XODateOption implements IOption {

    private Integer id;
	private Date date;
    private XOOptionList list;
    private List<String> votes;
	// the desired format
    private static final String pattern = "yyyy-MM-dd'T'HH:mm";

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
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
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

	 public static Date parseString(String dateString) throws Exception {
		 return new SimpleDateFormat(pattern).parse(dateString);
	 }

	@Override
	public String toString() {
		return new SimpleDateFormat(pattern).format(date);
	}


}
