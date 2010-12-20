/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.uniluebeck.itm.ep5.poll.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author hoschi
 */
@Entity
public class BOTextOption implements IOption, Serializable {
    @Transient
    private static final long serialVersionUID = -2030218482407285034L;
    @Id
    @GenericGenerator(name="seq_id", strategy="de.uniluebeck.itm.ep5.util.UuidGenerator")
	@GeneratedValue(generator="seq_id")
    private String id;
    @ManyToOne
    private BOOptionList list;
    @OneToMany
    private List<BOLocalizedString> strings;

    public BOTextOption() {
        this.strings = new ArrayList<BOLocalizedString>();
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
     * @return the list
     */
    public BOOptionList getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(BOOptionList list) {
        this.list = list;
    }


    /**
     * @return the strings
     */
    public List<BOLocalizedString> getStrings() {
        return strings;
    }

    /**
     * @param strings the strings to set
     */
    public void setStrings(List<BOLocalizedString> strings) {
        this.strings = strings;
    }

	@Override
	public void addVote(String voter) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
