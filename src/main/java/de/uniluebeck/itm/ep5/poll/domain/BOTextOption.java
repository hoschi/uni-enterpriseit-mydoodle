/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.uniluebeck.itm.ep5.poll.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author hoschi
 */
@Entity
public class BOTextOption implements Serializable {
    @Transient
    private static final long serialVersionUID = -2030218482407285034L;
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private BOOptionList list;
    @OneToMany
    private List<BOLocalizedString> strings;
    @ElementCollection
    private List<String> votes;

    public BOTextOption() {
        this.strings = new ArrayList<BOLocalizedString>();
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
     * @return the strings
     */
    public List<BOLocalizedString> getStrings() {
        return strings;
    }

    /**
     * @param strings the strings to set
     */
    public void setStrings(List<BOLocalizedString> strings) {
        this.strings = strings;
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

}
