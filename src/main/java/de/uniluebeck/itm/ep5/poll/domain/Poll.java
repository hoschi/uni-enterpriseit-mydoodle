package de.uniluebeck.itm.ep5.poll.domain;

import static java.lang.String.format;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
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
	
	@OneToMany
	private List<OptionList> options;
	private boolean isPublic;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date startDate;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date endDate;
	

	public Poll() {
	}

	public Poll(String title) {
		this.title = title;
		this.options = new ArrayList<OptionList>();
	}

	public Poll(Integer id, String title, List<OptionList> options) {
		this.id = id;
		this.title = title;
		this.options = options;
	}

	public Poll(String title, boolean isPublic) {
		this.title = title;
		this.isPublic = isPublic;
	}

	public void addOptionList(OptionList list) {
		if (!options.contains(list)) {
			options.add(list);
		}
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public List<OptionList> getOptionLists() {
		return options;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setOptions(List<OptionList> options) {
		this.options = options;
	}

	public void isPublic(boolean is) {
		this.isPublic = is;
	}
	
	public boolean isPublic() {
		return this.isPublic;
	}

	public boolean isActive() {

		if (this.startDate == null || this.endDate == null)
			return true;

		Date now = GregorianCalendar.getInstance().getTime();
		if (this.startDate.before(now) && this.endDate.after(now)) {
			return true;
		}

		return false;
	}

	public static Poll copy(Poll src) {
		return new Poll(src.getId(), src.getTitle(), src.getOptionLists());
	}

	@Override
	public String toString() {
		return format("Poll: id=%s, title=%s, #options=%s", getId(),
				getTitle(), getOptionLists().size());
	}

	public void setActiveTimeSpan(Date start, Date end) {
		this.startDate = start;
		this.endDate = end;
	}



}
