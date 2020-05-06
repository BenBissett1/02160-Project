package test;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import main.dataStructure;
import main.Client;
import main.Journey;

public class dataStructureTest {

	private static dataStructure d;
	private static Client c;
	private static Journey j;
	private static String companyPassword = "0000";
	
	@Before
	public void createEmptydataStructure() {
		d = new dataStructure();
	}
	
	@Test
	public void testGenerate() {
		assertNotSame(d.generate(1000, 1),d.generate(1000, 2));
		assertNotNull(d.generate(1000, 1));
		assertNotNull(d.generate(1000, 2));
		assertNull(d.clients.get(d.generate(1000, 1)));
	}

	@Test
	public void testCompanyPasswordMatch() {
		companyPassword = "0000";
		assertTrue("Company Password should be 0000",d.companyPasswordMatch(companyPassword));
	}

	@Test
	public void testChangeCompanyPassword() {
	}

	@Test
	public void testAllClients() {
		assertEquals("Should contain 0 clientIDs",d.allClients(),Collections.EMPTY_LIST);
		int john = c.regNewClient("John Smith","abc123", "2705 Eagle Street", "johnsmith@gmail.com" , "60188401");
		assertNotSame("Should contain 1 clientID",d.allClients(),Collections.EMPTY_LIST);
	}

	@Test
	public void testAllJourneys() {
		assertEquals("Should contain 0 journeyIDs",d.allJourneys(),Collections.EMPTY_LIST);
		j.regNewJourney("Copenhagen" , "New York" , "Beer", c.searchC("John Smith", 0));
		assertNotSame("Should contain 1 journeyID",d.allJourneys(),Collections.EMPTY_LIST);
	}
}
