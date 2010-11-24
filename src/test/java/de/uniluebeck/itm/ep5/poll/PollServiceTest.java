package de.uniluebeck.itm.ep5.poll;

//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.uniluebeck.itm.ep5.poll.domain.Option;
import de.uniluebeck.itm.ep5.poll.domain.Poll;
import de.uniluebeck.itm.ep5.poll.service.PollService;

public class PollServiceTest {

	final static Logger logger = LoggerFactory.getLogger(PollServiceTest.class);

	@Test
	public void simplePoll() {
		// Create the spring container using the XML configuration in
		// application-context.xml
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"application-context.xml");

		// Retrieve the beans we'll use during testing
		PollService pollService = ctx.getBean(PollService.class);

		// Create options to test
		Option wine = new Option("Wine", "red and tasty", 0);
		Option beer = new Option("Beer", "cold and tasty", 0);
		Option whiskey = new Option("Whiskey", "strong and tasty", 0);

		// Create voting to test
		Poll poll = new Poll("Which drink?");
		poll.addOption(wine);
		poll.addOption(beer);
		poll.addOption(whiskey);
		pollService.addPoll(poll);

		// Print all polls and options
		for (Poll p : pollService.getPolls()) {
			logger.info(p.toString());
			for (Option o : p.getOptions()) {
				logger.info(o.toString());
			}
		}

	}
}
