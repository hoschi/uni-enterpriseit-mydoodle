/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.uniluebeck.itm.ep5.poll.domain;

import java.io.Serializable;

/**
 *
 * @author hoschi
 */
public class XOLocalizedString implements IOption, Serializable {
    private static final long serialVersionUID = -2030218482407285034L;
    private Integer id;
    private String text;
    private String locale;

    public XOLocalizedString() {
    }

    public XOLocalizedString(String text, String locale){
        this.locale = locale;
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
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     * @param locale the locale to set
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }
}
