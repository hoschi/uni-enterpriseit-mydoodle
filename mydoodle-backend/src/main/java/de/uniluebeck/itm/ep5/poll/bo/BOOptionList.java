/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.poll.bo;

import de.uniluebeck.itm.ep5.poll.domain.IOption;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author hoschi
 */
@Entity
public class BOOptionList implements Serializable {

    @Transient
    private static final long serialVersionUID = -2030218482407285034L;
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    @OneToMany(targetEntity = BODateOption.class)
    private List<IOption> dates;
    @OneToMany(targetEntity = BOTextOption.class)
    private List<IOption> texts;

    public BOOptionList() {
        this.dates = new ArrayList<IOption>();
        this.texts = new ArrayList<IOption>();
    }

    public void addOption(IOption option) {
        if (option instanceof BODateOption) {
            this.dates.add(option);
        } else if (option instanceof BOTextOption) {
            this.texts.add(option);
        } else {
            throw new RuntimeException("no known option type");
        }
    }

    public List<IOption> getOptions() {
        List<IOption> list = new ArrayList<IOption>();
        list.addAll(this.dates);
        list.addAll(this.texts);
        return list;
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
     * @return the dates
     */
    public List<IOption> getDates() {
        return dates;
    }

    /**
     * @param dates the dates to set
     */
    public void setDates(List<IOption> dates) {
        this.dates = dates;
    }

    /**
     * @return the texts
     */
    public List<IOption> getTexts() {
        return texts;
    }

    /**
     * @param texts the texts to set
     */
    public void setTexts(List<IOption> texts) {
        this.texts = texts;
    }

}
