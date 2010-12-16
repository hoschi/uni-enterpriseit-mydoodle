/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.poll.service;

import de.uniluebeck.itm.ep5.poll.domain.XOOptionList;
import de.uniluebeck.itm.ep5.poll.domain.XOTextOption;
import de.uniluebeck.itm.ep5.poll.domain.xoPoll;
import de.uniluebeck.itm.pollservice.XsPoll;
import de.uniluebeck.itm.pollservice.XsPollInfo;
import de.uniluebeck.itm.pollservice.XsVote;
import java.util.List;
import java.util.Locale;
import org.junit.*;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author hoschi
 */
public class PollWebServiceImplTest {
// <editor-fold defaultstate="collapsed" desc="generated stuff">

	public PollWebServiceImplTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}// </editor-fold>
	final static Logger logger =
			LoggerFactory.getLogger(PollWebServiceImplTest.class);

	/**
	 * Test of getPolls method, of class PollWebServiceImpl.
	 */
	@Test
	public void testGetPolls() {
		logger.info("getPolls");
		PollWebServiceImpl instance = new PollWebServiceImpl();
		List<XsPollInfo> result;
		XsPollInfo info;

		logger.info("- insert multi lingual polls into DB");
		// create strings
		XOTextOption text = new XOTextOption();
        text.addString("hello", Locale.ENGLISH.toString());
        text.addString("hallo", Locale.GERMAN.toString());

		XOTextOption text1 = new XOTextOption();
        text1.addString("in the morning", Locale.ENGLISH.toString());
        text1.addString("morgens", Locale.GERMAN.toString());

		// save string options
        XOOptionList olist = new XOOptionList();
		olist.setTitle("strings");
        olist.addOption(text);
		olist.addOption(text1);

        xoPoll poll = new xoPoll("poll");
        poll.addOptionList(olist);

		logger.info("- get english poll infos");
		result = instance.getPolls(Locale.ENGLISH.toString());
		assertEquals(1, result.size());
		info = result.get(0);
		assertEquals(poll.getTitle(), info.getTitle());
		assertEquals(poll.getId(), info.getId());

		logger.info("- get german poll infos");
		result = instance.getPolls(Locale.GERMAN.toString());
		assertEquals(1, result.size());
		info = result.get(0);
		assertEquals(poll.getTitle(), info.getTitle());
		assertEquals(poll.getId(), info.getId());
	}

	/**
	 * Test of getPoll method, of class PollWebServiceImpl.
	 */
	@Test
	@Ignore
	public void testGetPoll() {
		logger.info("getPoll");
		String pollId = "";
		String languageCode = "";
		PollWebServiceImpl instance = new PollWebServiceImpl();
		XsPoll expResult = null;
		XsPoll result = instance.getPoll(pollId, languageCode);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of voteForOptions method, of class PollWebServiceImpl.
	 */
	@Test
	@Ignore
	public void testVoteForOptions() {
		logger.info("voteForOptions");
		XsVote voteForOptions = null;
		PollWebServiceImpl instance = new PollWebServiceImpl();
		instance.voteForOptions(voteForOptions);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}
