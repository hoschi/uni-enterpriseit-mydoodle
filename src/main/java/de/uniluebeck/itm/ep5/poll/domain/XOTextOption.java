package de.uniluebeck.itm.ep5.poll.domain;

import java.io.Serializable;
import java.util.*;

public class XOTextOption implements IOption, Serializable {
    private static final long serialVersionUID = -2030218482407285034L;
    private Integer id;
    private XOOptionList list;
    private List<BOLocalizedString> strings;

    public XOTextOption() {
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

    public void addString(String text, String locale) {
        BOLocalizedString s = new BOLocalizedString(text, locale);
        this.strings.add(s);
    }

}

