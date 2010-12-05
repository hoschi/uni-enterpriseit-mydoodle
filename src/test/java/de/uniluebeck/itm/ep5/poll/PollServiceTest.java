package de.uniluebeck.itm.ep5.poll;

//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.junit.Assert.assertThat;
import java.util.List;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.uniluebeck.itm.ep5.poll.domain.Option;
import de.uniluebeck.itm.ep5.poll.domain.Poll;
import de.uniluebeck.itm.ep5.poll.service.PollService;
import org.junit.Assert;

public class PollServiceTest {

    final static Logger logger = LoggerFactory.getLogger(PollServiceTest.class);

    /*
     * nutzer kann abstimmung anlegen
     */
    @Test
    public void addPoll() {
        // Create the spring container using the XML configuration in
        // application-context.xml
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "application-context.xml");

        // Retrieve the beans we'll use during testing
        PollService pollService = ctx.getBean(PollService.class);

        Poll poll = new Poll("createpoll");
        pollService.addPoll(poll);

        List<Poll> list = pollService.getPolls();
        Assert.assertEquals(1, list.size());

        // Print all polls and options
        for (Poll p : pollService.getPolls()) {
            logger.info(p.toString());
        }
    }

    /*
     * beim anlegen einer abstimmung wird eine eindeutige ID angeleget
     */
    @Test
    public void createPollId() {
        // Create the spring container using the XML configuration in
        // application-context.xml
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "application-context.xml");

        // Retrieve the beans we'll use during testing
        PollService pollService = ctx.getBean(PollService.class);

        Poll poll = new Poll("identity");
        pollService.addPoll(poll);

        poll = new Poll("identity1");
        pollService.addPoll(poll);
        List<Poll> list = pollService.getPolls();
        Assert.assertEquals(2, list.size());

        int id = list.get(0).getId();
        int id1 = list.get(1).getId();
        Assert.assertFalse(id == id1);

        // Print all polls and options
        for (Poll p : pollService.getPolls()) {
            logger.info(p.toString());
        }
    }

    /////////////////////////////////////////////////////
    // TODO _nur_ anleger kann eine angelegte abstimmung verwalten (CRUD)
    /////////////////////////////////////////////////////
    /////////////////////////////////////////////////////
    // TODO nutzer kann angbeben wie lange die abstimmung aktiv ist
    /////////////////////////////////////////////////////
    /////////////////////////////////////////////////////
    // TODO nutzer kann bestimmen ob die abstimmung public
    /////////////////////////////////////////////////////
    /////////////////////////////////////////////////////
    // TODO abstimmung kann beliebigviele optionlisten enthalten
    /////////////////////////////////////////////////////
    /////////////////////////////////////////////////////
    // TODO abstimmung kann beliebigviele optionen enthalten
    /////////////////////////////////////////////////////
    /////////////////////////////////////////////////////
    // TODO nutzer kann also option datum oder text angeben
    /////////////////////////////////////////////////////

    /*
     * TODO nutzer kann datums und frei text option anlegen
     */
    @Test
    public void createDateAndTextOptions() {
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
        Poll poll = new Poll("optiontest");
        poll.addOption(wine);
        poll.addOption(beer);
        poll.addOption(whiskey);
        pollService.addPoll(poll);
        List<Poll> list = pollService.getPolls();
        for (Poll p : list) {
            if (p.getTitle().equals("optiontest")) {
                Assert.assertEquals(3, p.getOptions().size());
            }
        }

        // Print all polls and options
        for (Poll p : pollService.getPolls()) {
            logger.info(p.toString());
            for (Option o : p.getOptions()) {
                logger.info(o.toString());
            }
        }
    }
    /////////////////////////////////////////////////////
    // TODO optionen können in verschiedenen sprachen eingeben un angezeigt werden
    /////////////////////////////////////////////////////
    /////////////////////////////////////////////////////
    // TODO nutzer kann abstimmen in dem er seinen namen angbibt und seine gewählten optionen
    /////////////////////////////////////////////////////
    /////////////////////////////////////////////////////
    // TODO interaktive abstimmungen können eingesehen werden
    /////////////////////////////////////////////////////
    /////////////////////////////////////////////////////
    // TODO interaktive abstimmungen können nicht mehr verändert werden
    /////////////////////////////////////////////////////
    /////////////////////////////////////////////////////
    // TODO nutzer kann abstimmungen nach titel suchen mit wildcards
    /////////////////////////////////////////////////////
}
