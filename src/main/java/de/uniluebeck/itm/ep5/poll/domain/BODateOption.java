/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.uniluebeck.itm.ep5.poll.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author hoschi
 */
@Entity
public class BODateOption implements IOption, Serializable {
    @Transient
    private static final long serialVersionUID = -2030218482407285034L;
    @Id
    @GenericGenerator(name="seq_id", strategy="de.uniluebeck.itm.ep5.util.UuidGenerator")
	@GeneratedValue(generator="seq_id")
    private String id;
    @ManyToOne
    private BOOptionList list;
    @ElementCollection
    private List<String> votes;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date;
    
    public Date getDate() {
        return date;
    }

    public BODateOption() {
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
    public BOOptionList getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(BOOptionList list) {
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

	/**
	 * @param date the date to set
	 */ public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public void addVote(String voter) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
