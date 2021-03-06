package de.uniluebeck.itm.ep5.poll.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "polls")
public class boPoll implements Serializable {

	@Transient
	private static final long serialVersionUID = -980869932728084332L;
	@Id
	@GenericGenerator(name = "seq_id", strategy = "de.uniluebeck.itm.ep5.util.UuidGenerator")
	@GeneratedValue(generator = "seq_id")
	private String id;
	private String title;
	@OneToMany
	private List<BOOptionList> options;
	private boolean isPublic;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date startDate;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date endDate;

	public boPoll() {
	}

	public boolean isActive() {

		Date now = GregorianCalendar.getInstance().getTime();
		boolean active;

		if (this.startDate == null && this.endDate ==
				null) {
			active = true;
		} else if (this.startDate != null && this.endDate !=
				null && this.startDate.before(now) && this.endDate.after(now)) {
			active = true;
		} else if (this.startDate != null && this.endDate == null && this.startDate.before(
				now)) {
			active = true;
		} else if (this.endDate != null && this.startDate == null && this.endDate.after(now)) {
			active = true;
		} else {
			active = false;
		}

		return active;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the options
	 */
	public List<BOOptionList> getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(List<BOOptionList> options) {
		this.options = options;
	}

	/**
	 * @return the isPublic
	 */
	public boolean isPublic() {
		return isPublic;
	}

	/**
	 * @param isPublic the isPublic to set
	 */
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
