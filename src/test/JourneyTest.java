package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.Client;
import main.Journey;

public class JourneyTest {
		
		private static Journey j;
		private static Client c;
	
		
		@Before
		public void createEmptyJourney() {
			j = new Journey();
		}	
	
	@Test
	public void testSearchJ() {
		assertEquals(j.searchJ("Copenhagen", 0, c.searchC("Billy Bob", 0)),Collections.EMPTY_LIST);
		int billybob = c.regNewClient("Billy Bob", "123", "222 Langogade" , "billybob@gmail.com", "60177401801");
		int billybobj = j.regNewJourney("Copenhagen", "New York", "bananas", billybob);
		assertNotNull(j.searchJ("Copenhagen", 0, billybob));
		assertNotNull(billybobj);
		assertEquals(j.searchJ("Copenhagen", 0, billybob),j.searchJ("New York", 1, billybob));
		assertEquals(j.searchJ("Copenhagen", 0, billybob),j.searchJ("bananas", 3, billybob));
	}

	@Test
	public void testRegNewJourney() {
		assertEquals(j.searchJ("Victoria", 0, c.searchC("James", 0)),Collections.EMPTY_LIST);
		int james = c.regNewClient("James", "1234", "Heron 55" , "james@gmail.com", "601774018017615761");
		int jamesj = j.regNewJourney("Victoria", "Tokyo", "kangaroos", james);
		assertNotNull(j.searchJ("Victoria", 0, james));
		assertNotNull(jamesj);
		assertEquals(j.searchJ("Victoria", 0, james),j.searchJ("Tokyo", 1, james));
		assertEquals(j.searchJ("Victoria", 0, james),j.searchJ("kangaroos", 3, james));
	}

	@Test
	public void testUpdateJourney() {
		
		int andre = c.regNewClient("Andre", "thor98", "Langogade 5" , "andre@gmail.com", "17740169");
		int andrej = j.regNewJourney("Cape Town", "Santiago", "mangos", andre);
		assertEquals("Status should be 'Origin'", "Origin", j.journeys.get(andrej).getStatus());
		j.updateJourney(andrej, "Cape Town", "Arrived at destination");
		assertEquals("Status should be 'Arrived at destination'", "Arrived at destination", j.journeys.get(andrej).getStatus());
		
	}

	@Test
	public void testJourneyExists() {
		int matias = c.regNewClient("Matias", "MIAoly", "Hawaii 50" , "matias@gmail.com", "11110000");
		int matiasj = j.regNewJourney("Honolulu", "Saipan", "coconuts", matias);
		assertTrue(j.journeyExists(matiasj));
	}

	@Test
	public void testGetTemp() {
		List<Float> L = new ArrayList<Float>();
		int matias = c.regNewClient("Matias", "MIAoly", "Hawaii 50" , "matias@gmail.com", "11110000");
		int matiasj = j.regNewJourney("Honolulu", "Saipan", "coconuts", matias);
		assertEquals(j.journeys.get(matiasj).getTemp(), Collections.EMPTY_LIST);
		j.updateContainerStatus(matiasj, 200, 20, 2);
		L.add(200F);
		assertEquals(L, j.journeys.get(matiasj).getTemp());
	}

	@Test
	public void testGetHum() {
		List<Float> L = new ArrayList<Float>();
		int matias = c.regNewClient("Matias", "MIAoly", "Hawaii 50" , "matias@gmail.com", "11110000");
		int matiasj = j.regNewJourney("Honolulu", "Saipan", "coconuts", matias);
		assertEquals(j.journeys.get(matiasj).getHum(), Collections.EMPTY_LIST);
		j.updateContainerStatus(matiasj, 200, 20, 2);
		L.add(20F);
		assertEquals(L, j.journeys.get(matiasj).getHum());
	}

	@Test
	public void testGetPres() {
		List<Float> L = new ArrayList<Float>();
		int matias = c.regNewClient("Matias", "MIAoly", "Hawaii 50" , "matias@gmail.com", "11110000");
		int matiasj = j.regNewJourney("Honolulu", "Saipan", "coconuts", matias);
		assertEquals(j.journeys.get(matiasj).getPres(), Collections.EMPTY_LIST);
		j.updateContainerStatus(matiasj, 200, 20, 2);
		L.add(2F);
		assertEquals(L, j.journeys.get(matiasj).getPres());
	}

	@Test
	public void testGetLastTemp() {
		List<Float> L = new ArrayList<Float>();
		int matias = c.regNewClient("Matias", "MIAoly", "Hawaii 50" , "matias@gmail.com", "11110000");
		int matiasj = j.regNewJourney("Honolulu", "Saipan", "coconuts", matias);
		assertEquals(j.journeys.get(matiasj).getTemp(), Collections.EMPTY_LIST);
		j.updateContainerStatus(matiasj, 200, 20, 2);
		L.add(200F);
		assertEquals(L, j.journeys.get(matiasj).getTemp());
		assertEquals(200,Math.round(j.journeys.get(matiasj).getLastTemp()));
	}

	@Test
	public void testGetLastHumidity() {
		List<Float> L = new ArrayList<Float>();
		int matias = c.regNewClient("Matias", "MIAoly", "Hawaii 50" , "matias@gmail.com", "11110000");
		int matiasj = j.regNewJourney("Honolulu", "Saipan", "coconuts", matias);
		assertEquals(j.journeys.get(matiasj).getHum(), Collections.EMPTY_LIST);
		j.updateContainerStatus(matiasj, 200, 20, 2);
		L.add(20F);
		assertEquals(L, j.journeys.get(matiasj).getHum());
		assertEquals(20,Math.round(j.journeys.get(matiasj).getLastHumidity()));
	}

	@Test
	public void testGetLastAtmPressure() {
		List<Float> L = new ArrayList<Float>();
		int matias = c.regNewClient("Matias", "MIAoly", "Hawaii 50" , "matias@gmail.com", "11110000");
		int matiasj = j.regNewJourney("Honolulu", "Saipan", "coconuts", matias);
		assertEquals(j.journeys.get(matiasj).getPres(), Collections.EMPTY_LIST);
		j.updateContainerStatus(matiasj, 200, 20, 2);
		L.add(2F);
		assertEquals(L, j.journeys.get(matiasj).getPres());
		assertEquals(2,Math.round(j.journeys.get(matiasj).getLastAtmPressure()));
	}

	@Test
	public void testGetDestination() {
		int matias = c.regNewClient("Matias", "MIAoly", "Hawaii 50" , "matias@gmail.com", "11110000");
		int matiasj = j.regNewJourney("Honolulu", "Saipan", "coconuts", matias);
		assertEquals("Saipan",j.journeys.get(matiasj).getDestination());
	}

	@Test
	public void testGetStatus() {
		int matias = c.regNewClient("Matias", "MIAoly", "Hawaii 50" , "matias@gmail.com", "11110000");
		int matiasj = j.regNewJourney("Honolulu", "Saipan", "coconuts", matias);
		assertEquals("Origin",j.journeys.get(matiasj).getStatus());
	}

	@Test
	public void testGetOrigin() {
		int matias = c.regNewClient("Matias", "MIAoly", "Hawaii 50" , "matias@gmail.com", "11110000");
		int matiasj = j.regNewJourney("Honolulu", "Saipan", "coconuts", matias);
		assertEquals("Honolulu",j.journeys.get(matiasj).getOrigin());
	}

	@Test
	public void testGetContent() {
		int matias = c.regNewClient("Matias", "MIAoly", "Hawaii 50" , "matias@gmail.com", "11110000");
		int matiasj = j.regNewJourney("Honolulu", "Saipan", "coconuts", matias);
		assertEquals("coconuts",j.journeys.get(matiasj).getContent());
	}

	@Test
	public void testGetClientID() {
		int matias = c.regNewClient("Matias", "MIAoly", "Hawaii 50" , "matias@gmail.com", "11110000");
		int matiasj = j.regNewJourney("Honolulu", "Saipan", "coconuts", matias);
		assertEquals("" + matias,j.journeys.get(matiasj).getClientID());
	}
	@Test
	public void testUpdateContainerStatus() {
		List<Float> L = new ArrayList<Float>();
		int matias = c.regNewClient("Matias", "MIAoly", "Hawaii 50" , "matias@gmail.com", "11110000");
		int matiasj = j.regNewJourney("Honolulu", "Saipan", "coconuts", matias);
		assertEquals(j.journeys.get(matiasj).getTemp(), Collections.EMPTY_LIST);
		assertEquals(j.journeys.get(matiasj).getHum(), Collections.EMPTY_LIST);
		assertEquals(j.journeys.get(matiasj).getPres(), Collections.EMPTY_LIST);
		j.updateContainerStatus(matiasj, 200, 20, 2);
		L.add(200F);
		assertEquals(L, j.journeys.get(matiasj).getTemp());
		L.remove(0);
		L.add(20F);
		assertEquals(L, j.journeys.get(matiasj).getHum());
		L.remove(0);
		L.add(2F);
		assertEquals(L, j.journeys.get(matiasj).getPres());
	}

}
