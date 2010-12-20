/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.uniluebeck.itm.ep5.poll.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author hoschi
 */
@Entity
public class BOVote implements Serializable {
	@Transient
    private static final long serialVersionUID = -2030218482407285034L;
    @Id
	@GeneratedValue
	private int id;
	private String voter;
	private String optionId;

	public BOVote() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOptionId() {
		return optionId;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}

	public String getVoter() {
		return voter;
	}

	public void setVoter(String voter) {
		this.voter = voter;
	}

}
