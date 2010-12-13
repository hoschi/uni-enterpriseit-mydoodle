/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.uniluebeck.itm.ep5.poll.domain;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author hoschi
 */
@Entity
public class BOTextOption implements IOption, Serializable {
    @Transient
    private static final long serialVersionUID = -2030218482407285034L;
    @Id
    @GeneratedValue
    private Integer id;
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
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
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

}
