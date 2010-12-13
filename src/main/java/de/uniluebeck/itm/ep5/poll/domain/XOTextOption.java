package de.uniluebeck.itm.ep5.poll.domain;

import java.util.ArrayList;
import java.util.List;

public class XOTextOption implements IOption {
    private Integer id;
    private XOOptionList list;
    private List<XOLocalizedString> strings;

    public XOTextOption() {
        this.strings = new ArrayList<XOLocalizedString>();
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
    public List<XOLocalizedString> getStrings() {
        return strings;
    }

    /**
     * @param strings the strings to set
     */
    public void setStrings(List<XOLocalizedString> strings) {
        this.strings = strings;
    }

    public void addString(String text, String locale) {
        XOLocalizedString s = new XOLocalizedString(text, locale);
        this.strings.add(s);
    }

}

