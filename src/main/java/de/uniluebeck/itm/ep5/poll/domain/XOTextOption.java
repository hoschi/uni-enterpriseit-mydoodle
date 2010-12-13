package de.uniluebeck.itm.ep5.poll.domain;

import java.io.Serializable;

public class XOTextOption implements IOption, Serializable {
    private static final long serialVersionUID = -2030218482407285034L;
    private Integer id;
    private XOOptionList list;
    private String text;

    public XOTextOption() {
    }

    public XOTextOption(String text){
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
    public XOOptionList getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(XOOptionList list) {
        this.list = list;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

}

