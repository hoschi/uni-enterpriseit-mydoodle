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
}
