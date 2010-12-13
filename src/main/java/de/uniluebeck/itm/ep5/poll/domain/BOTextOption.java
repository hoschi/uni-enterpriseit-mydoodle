/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.uniluebeck.itm.ep5.poll.domain;

import java.io.Serializable;
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
    private String text;

    public BOTextOption() {
    }

    public BOTextOption(String text){
        this.text = text;
    }
    public String getText() {
        return text;
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
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

}
