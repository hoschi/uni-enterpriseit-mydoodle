package de.uniluebeck.itm.ep5.poll.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class xoPoll implements Serializable{

    private String id;
    private String title;
    private List<XOOptionList> options;
    private boolean isPublic;
    private Date startDate;
    private Date endDate;

    public xoPoll() {
		this.options = new ArrayList<XOOptionList>();
    }

    public xoPoll(String title) {
        this.title = title;
        this.options = new ArrayList<XOOptionList>();
    }

    public xoPoll(String id, String title, List<XOOptionList> options) {
        this.id = id;
        this.title = title;
        this.options = options;
    }

    public xoPoll(String title, boolean isPublic) {
        this.title = title;
        this.isPublic = isPublic;
		this.options = new ArrayList<XOOptionList>();
    }

    public void addOptionList(XOOptionList list) {
        if (!options.contains(list)) {
            options.add(list);
        }
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<XOOptionList> getOptionLists() {
        return options;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOptions(List<XOOptionList> options) {
        this.options = options;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }
    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }
    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    
    public void setActiveTimeSpan(Date start, Date end) {
        this.startDate = start;
        this.endDate = end;
    }

}
