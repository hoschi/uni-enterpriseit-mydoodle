package de.uniluebeck.itm.ep5.poll.domain;

import static java.lang.String.format;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "options")
public class Option implements Serializable {

	@Transient
	private static final long serialVersionUID = -2030218482407285034L;
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String description;
	private int votes;
	@ManyToOne
	private Poll poll;

	public Option() {
	}

	public Option(String title, String description, int votes) {
		this.title = title;
		this.description = description;
		this.votes = votes;
	}

	public Option(Integer id, String title, String description, int votes) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.votes = votes;
	}

	public void addVote() {
		votes += 1;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getVotes() {
		return votes;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

	public static Option copy(Option src) {
		return new Option(src.getId(), src.getTitle(), src.getDescription(),
				src.getVotes());
	}

	@Override
	public String toString() {
		return format("Option: id=%s, title=%s, votes=%s", getId(), getTitle(),
				getVotes());
	}
}
