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
		List<IOption> list = new ArrayList<IOption>();
		list.addAll(this.dates);
		list.addAll(this.texts);
		return list;
	}
	
	public Object clone() {
		OptionList result = new OptionList();
		result.id = id;
		result.title = title;
		for (IOption o : dates) {
			DateOption clone = (DateOption)((DateOption)o).clone();
			clone.setOptionList(result);
			result.dates.add(clone);
		}
		for (IOption o : texts) {
			TextOption clone = (TextOption)((TextOption)o).clone();
			clone.setOptionList(result);
			result.texts.add(clone);
		}
		return result;
	}
}
