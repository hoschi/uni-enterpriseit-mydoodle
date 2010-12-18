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

/**
 *
 * @author hoschi
 */
@Entity
public class BODateOption implements Serializable {
    @Transient
    private static final long serialVersionUID = -2030218482407285034L;
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private BOOptionList list;
    @ElementCollection
    private List<String> votes;
	@Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    
    public Date getDate() {
        return GregorianCalendar.getInstance().getTime();
    }

    public BODateOption() {
        this.setVotes(new ArrayList<String>());
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


}
