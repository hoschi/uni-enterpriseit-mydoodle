package de.uniluebeck.itm.ep5.poll.domain;

import de.uniluebeck.itm.ep5.poll.service.PollService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XOTextOption implements IOption {

	private String id;
	private XOOptionList list;
	private List<XOLocalizedString> strings;
	private PollService pollService;

	public XOTextOption() {
		// Create the spring container using the XML configuration in
        // application-context.xml
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "application-context.xml");

        // Retrieve the beans we'll use during testing
        pollService = ctx.getBean(PollService.class);
		this.strings = new ArrayList<XOLocalizedString>();
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

	public void addVote(String voter) {
		this.pollService.addVote(this, voter);
	}

	public void removeVote(String voter) {
		this.pollService.removeVote(this, voter);
	}

	public List<String> getVotes() {
		return pollService.getVotes(this);
	}

	public String getStringByLocale(String languageCode) {
		for (XOLocalizedString lString : this.getStrings()) {
			if (lString.getLocale().equals(languageCode)) {
				return lString.getText();
			}
		}
		return null;
	}
}
