/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.uniluebeck.itm.ep5.poll.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.*;

/**
 *
 * @author hoschi
 */
@Entity
public class DateOption implements IOption, Serializable {
	@Transient
	private static final long serialVersionUID = -2030218482407285034L;
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	private OptionList list;
	public Date getDate() {
		return GregorianCalendar.getInstance().getTime();
	}

}
