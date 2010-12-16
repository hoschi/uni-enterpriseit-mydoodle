/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.poll.service;

import de.uniluebeck.itm.pollservice.XsPoll;
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
	@Ignore
	public void testGetPolls() {
		logger.info("getPolls");
		Locale l = new Locale("en");
		logger.info(l.getLanguage());
		logger.info(Locale.getISOLanguages().toString());
		String languageCode = "";
		PollWebServiceImpl instance = new PollWebServiceImpl();
		List expResult = null;
		//List result = instance.getPolls(languageCode);
		//assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		//fail("The test case is a prototype.");
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
