package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Client;

public class ClientTest {
	
	private Client c;
	
	@Before
	public void createEmptyClient() {
		c = new Client();
	}

	@Test
	public void testSetName() {
		c = new Client();
		c.setName("John Smith");
		assertEquals("Should be John Smith", "John Smith",c.getName()); 
	}

	@Test
	public void testSetPassword() {
		c = new Client();
		c.setPassword("abc123");
		assertEquals("Should be abc123","abc123",c.getPassword()); 
	}
	
	@Test
	public void testSetAddress() {
		c = new Client();
		c.setAddress("2705 Eagle Street");
		assertEquals("Should be 2705 Eagle Street","2705 Eagle Street",c.getAddress()); 
	}
	
	@Test
	public void testSetEmail() {
		c = new Client();
		c.setEmail("johnsmith@gmail.com");
		assertEquals("Should be johnsmith@gmail.com","johnsmith@gmail.com",c.getEmail()); 
	}
	
	@Test
	public void testSetPhone() {
		c = new Client();
		c.setPhone("60188401");
		assertEquals("Should be 60188401", "60188401",c.getPhone()); 
	}
	
	@Test
	public void testSetID() {
		
	}
	
//	
//	@Test
//	public void testRegNewClient() {
//		Client.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401");
//		assertEquals(Client.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401"),Client.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401"));
//	}
//
	@Test
	public void testUpdateClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testClientExists() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPhone() {
		fail("Not yet implemented");
	}

}
