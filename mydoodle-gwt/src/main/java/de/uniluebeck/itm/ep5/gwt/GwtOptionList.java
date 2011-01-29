/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.gwt;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author hoschi
 */
class GwtOptionList implements Serializable {

	private Integer id;
	private String title;
	private List<IGwtOption> dates;
	private List<IGwtOption> texts;

	public List<IGwtOption> getDates() {
		return dates;
	}

	public void setDates(List<IGwtOption> dates) {
		this.dates = dates;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<IGwtOption> getTexts() {
		return texts;
	}

	public void setTexts(List<IGwtOption> texts) {
		this.texts = texts;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
