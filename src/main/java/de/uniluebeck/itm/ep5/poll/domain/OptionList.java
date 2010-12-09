/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.poll.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author hoschi
 */
@Entity
public class OptionList implements Serializable {

	@Transient
	private static final long serialVersionUID = -2030218482407285034L;
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	@OneToMany(targetEntity = DateOption.class)
	private List<IOption> dates;
	@OneToMany(targetEntity = TextOption.class)
	private List<IOption> texts;

	public OptionList() {
		this.dates = new ArrayList<IOption>();
		this.texts = new ArrayList<IOption>();
	}

	public void addOption(IOption option) {
		if (option instanceof DateOption) {
			this.dates.add(option);
		} else if (option instanceof TextOption) {
			this.texts.add(option);
		} else {
			throw new RuntimeException("no known option type");
		}
	}

	public List<IOption> getOptions() {
		List<IOption> list = new ArrayList();
		list.addAll(this.dates);
		list.addAll(this.texts);
		return list;
	}
}
