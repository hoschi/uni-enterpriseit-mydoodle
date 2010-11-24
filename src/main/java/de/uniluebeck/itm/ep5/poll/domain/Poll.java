package de.uniluebeck.itm.ep5.poll.domain;

import static java.lang.String.format;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "polls")
public class Poll implements Serializable {

	@Transient
	private static final long serialVersionUID = -980869932728084332L;
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	// Default fetch type would be LAZY. But lazy fetching does not work
	// when the session/transaction is already closed at the time the
	// options list's lazy initialization is triggered.
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Option.class)
	private List<Option> options;

	public Poll() {
	}

	public Poll(String title) {
		this.title = title;
		this.options = new ArrayList<Option>();
	}

	public Poll(Integer id, String title, List<Option> options) {
		this.id = id;
		this.title = title;
		this.options = options;
	}

	public void addOption(Option option) {
		if (!options.contains(option)) {
			options.add(option);
		}
	}

	public void addOptions(List<Option> option) {
		for (Option o : options) {
			addOption(o);
		}
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public static Poll copy(Poll src) {
		return new Poll(src.getId(), src.getTitle(), src.getOptions());
	}

	@Override
	public String toString() {
		return format("Poll: id=%s, title=%s, #options=%s", getId(),
				getTitle(), getOptions().size());
	}
}
