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
public class TextOption implements IOption, Serializable {
	@Transient
	private static final long serialVersionUID = -2030218482407285034L;
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	private OptionList list;
	private String text;

	public TextOption() {
	}

	public TextOption(String text){
		this.text = text;
	}
	public String getText() {
		return text;
	}
	
	public void setOptionList(OptionList list) {
		this.list = list;
	}
	
	public Object clone() {
		TextOption result = new TextOption();
		result.id = id;
		result.text = text;
		return result;
	}

}
