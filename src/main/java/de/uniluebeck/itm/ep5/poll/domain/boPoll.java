package de.uniluebeck.itm.ep5.poll.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

@Entity
@Table(name = "polls")
public class boPoll implements Serializable {

	@Transient
	private static final long serialVersionUID = -980869932728084332L;
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	@OneToMany
	private List<OptionList> options;
	private boolean isPublic;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date startDate;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date endDate;

	public boPoll() {
	}

	public boPoll(xoPoll poll) {
		this.id = poll.getId();
		this.title = poll.getTitle();
		
		this.options = cloneList(poll.getOptionLists());
		
		this.isPublic = poll.isPublic();
		this.startDate = poll.getStartDate();
		this.endDate = poll.getEndDate();
	}

	public xoPoll toX() {
		xoPoll x = new xoPoll();
		x.setActiveTimeSpan(this.startDate, this.endDate);
		x.setId(this.id);
		x.setTitle(title);
		
		x.setOptions(cloneList(options));
		
		x.isPublic(isPublic);
		return x;
	}
	
	private static <T> List<T> cloneList(List<T> list) {
		if (list == null)
			return null;
		List<T> result = new LinkedList<T>();
		result.addAll(list);
		return result;
	}

	public Integer getId() {
		return this.id;
	}
}
