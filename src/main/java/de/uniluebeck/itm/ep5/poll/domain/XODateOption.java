package de.uniluebeck.itm.ep5.poll.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class XODateOption implements IOption, Serializable {
    private static final long serialVersionUID = -2030218482407285034L;

    private Integer id;

    private XOOptionList list;
    public Date getDate() {
        return GregorianCalendar.getInstance().getTime();
    }

    public XODateOption() {}

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


}
