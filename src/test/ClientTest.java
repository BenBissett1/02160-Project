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
		c.setName("John Smith");
		assertEquals("Should be John Smith", "John Smith",c.getName()); 
	}

	@Test
	public void testSetPassword() {
		c.setPassword("abc123");
		assertEquals("Should be abc123","abc123",c.getPassword()); 
	}
	
	@Test
	public void testSetAddress() {
		c.setAddress("2705 Eagle Street");
		assertEquals("Should be 2705 Eagle Street","2705 Eagle Street",c.getAddress()); 
	}
	
	@Test
	public void testSetEmail() {
		c.setEmail("johnsmith@gmail.com");
		assertEquals("Should be johnsmith@gmail.com","johnsmith@gmail.com",c.getEmail()); 
	}
	
	@Test
	public void testSetPhone() {
		c.setPhone("60188401");
		assertEquals("Should be 60188401", "60188401",c.getPhone()); 
	}
	
//	@Test
//	public void testSetID() {
//		c.setID(1234);
//		assertEquals(c.setID(),1234);
//	}
//	
//	
//	@Test
//	public void testRegNewClient() {
//		Client.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401");
//		assertEquals(Client.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401"),Client.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401"));
//	}
//
//	@Test
//	public void testUpdateClient() {
//	}

	@Test
	public void testClientExists() {
		c.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401");
		assertNotSame(c.clientExists(c.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401")),null);
	}

	@Test
	public void testGetID() {
		c.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401");
		c.getID();
		assertNotNull(c.getID());
	}

	@Test
	public void testGetName() {
		c.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401");
		c.setName("John Smith");
		assertSame(c.getName(),"John Smith");
	}

	@Test
	public void testGetPassword() {
		c.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401");
		c.setPassword("123abc");
		assertSame(c.getPassword(),"123abc");
	}

	@Test
	public void testGetAddress() {
		c.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401");
		c.setAddress("2705 Heron Street");
		assertSame(c.getAddress(),"2705 Heron Street");
	}

	@Test
	public void testGetEmail() {
		c.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401");
		c.setEmail("johnsmith@gmail.com");
		assertSame(c.getEmail(),"johnsmith@gmail.com");
	}

	@Test
	public void testGetPhone() {
		c.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401");
		c.setPhone("60188401");
		assertSame(c.getPhone(),"60188401");
	}

}
