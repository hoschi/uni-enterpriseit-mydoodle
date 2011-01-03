/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.poll.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author hoschi
 */
@Entity
public class BOTextOption implements IOption, Serializable {

	@Transient
	private static final long serialVersionUID = -2030218482407285034L;
	@Id
	@GenericGenerator(name = "seq_id", strategy = "de.uniluebeck.itm.ep5.util.UuidGenerator")
	@GeneratedValue(generator = "seq_id")
	private String id;
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

	@Override
	public void addVote(String voter) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void filterVotes() {
		// we need distinct votes, this isn't done by hibernate because
		// votes are an element collection
		List<String> votes = this.getVotes();
		Set<String> dist = new HashSet<String>(votes);
		this.setVotes(new ArrayList<String>(dist));
	}
}
