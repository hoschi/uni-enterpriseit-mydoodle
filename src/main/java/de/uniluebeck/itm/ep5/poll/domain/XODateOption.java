package de.uniluebeck.itm.ep5.poll.domain;

import de.uniluebeck.itm.ep5.poll.service.PollService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XODateOption implements IOption {

    private String id;
	private Date date;
    private XOOptionList list;
	private PollService pollService;


	// the desired format
    private static final String pattern = "yyyy-MM-dd'T'HH:mm";

    public XODateOption() {
		// Create the spring container using the XML configuration in
        // application-context.xml
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "application-context.xml");

        // Retrieve the beans we'll use during testing
        pollService = ctx.getBean(PollService.class);
    }

	public XODateOption(Date date) {
		// Create the spring container using the XML configuration in
        // application-context.xml
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "application-context.xml");

        // Retrieve the beans we'll use during testing
        pollService = ctx.getBean(PollService.class);
		this.date = date;
    }

    public Date getDate() {
        return date;
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
    public XOOptionList getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(XOOptionList list) {
        this.list = list;
    }

	public void addVote(String voter) {
		this.pollService.addVote(this, voter);
	}
	
	public void removeVote(String voter) {
		this.pollService.removeVote(this, voter);
	}

	public List<String> getVotes() {
		return pollService.getVotes(this);
	}

	/**
	 * @param date the date to set
	 */ public void setDate(Date date) {
		this.date = date;
	}

	 public static Date parseString(String dateString) throws Exception {
		 return new SimpleDateFormat(pattern).parse(dateString);
	 }

	@Override
	public String toString() {
		return new SimpleDateFormat(pattern).format(date);
	}


}
