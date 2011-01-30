/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.poll;

import de.uniluebeck.itm.ep5.poll.domain.XODateOption;
import de.uniluebeck.itm.ep5.poll.domain.XOOptionList;
import de.uniluebeck.itm.ep5.poll.domain.XOTextOption;
import de.uniluebeck.itm.ep5.poll.domain.xoPoll;
import de.uniluebeck.itm.ep5.poll.service.PollService;
import de.uniluebeck.itm.ep5.poll.service.PollWebServiceImpl;
import de.uniluebeck.itm.pollservice.PollWebService;
import de.uniluebeck.itm.pollservice.Pollservice;
import de.uniluebeck.itm.pollservice.XsPoll;
import de.uniluebeck.itm.pollservice.XsPollInfo;
import de.uniluebeck.itm.pollservice.XsVote;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.xml.ws.Endpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author hoschi
 */
public class MainServer {
	
	final static Logger logger =
			LoggerFactory.getLogger(MainServer.class);

	public static void main(String[] args) {
		logger.info("starting service");
		Endpoint.publish("http://localhost:8080/poll", new PollWebServiceImpl());
		logger.info("service stared");
		createData();
	}

	private static void createData() {
		logger.info("adding data to db");
		ApplicationContext ctx;
		PollService pollService;
		// Create the spring container using the XML configuration in
		// application-context.xml
		ctx = new ClassPathXmlApplicationContext(
				"application-context.xml");

		// Retrieve the beans we'll use during testing
		pollService = ctx.getBean(PollService.class);

		xoPoll poll;

		// create strings
		XOTextOption text = new XOTextOption();
		text.addString("hello", Locale.ENGLISH.toString());
		text.addString("hallo", Locale.GERMAN.toString());
		text.addVote("hoschi");

		XOTextOption text1 = new XOTextOption();
		text1.addString("in the morning", Locale.ENGLISH.toString());
		text1.addString("morgens", Locale.GERMAN.toString());
		text1.addVote("hoschi");
		text1.addVote("jacob");

		// create dates option
		GregorianCalendar yesterday = new GregorianCalendar();
		yesterday.add(GregorianCalendar.DAY_OF_MONTH, -1);
		XODateOption date = new XODateOption(yesterday.getTime());

		// save string options
		XOOptionList olist = new XOOptionList();
		olist.setTitle("strings");
		olist.addOption(text);
		olist.addOption(text1);
		olist.addOption(date);

		poll = new xoPoll("poll1");
		poll.setPublic(true);
		poll.addOptionList(olist);
		pollService.addPoll(poll);

		poll = new xoPoll("poll2");
		poll.setPublic(true);
		pollService.addPoll(poll);
		
		poll = new xoPoll("poll3");
		pollService.addPoll(poll);
		logger.info("data added to db");
	}
}
