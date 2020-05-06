package test;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import main.Client;

public class ClientTest {
	
	private static Client c;
	
	@Before
	public void createEmptyClient() {
		c = new Client();
	}

	
	@Test
	public void testSearchC() {
		int jonah = c.regNewClient("Jonah", "123", "2707 Heron Street","jonah@gmail.com","11112222");
		assertEquals(jonah,c.searchC("Jonah", 0)); 
		assertEquals(jonah,c.searchC("2707 Heron Street", 2));
		assertEquals(jonah,c.searchC("jonah@gmail.com", 3));
		assertEquals(jonah,c.searchC("11112222", 4));
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
	
	@Test
	public void testRegNewClient() {
		int bob = c.regNewClient("Bob", "123456", "2706 Heron Street","Bob@gmail.com","12345678");
		assertEquals(bob,c.searchC("Bob", 0));
	}

	@Test
	public void testClientExists() {
		int john = c.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401");
		assertNotSame(c.clientExists(john),null);
	}

	@Test
	public void testGetID() {
		int john = c.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401");
		c.getID();
		assertNotNull(c.getID());
	}

	@Test
	public void testGetName() {
		int john = c.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401");
		c.setName("John Smith");
		assertSame(c.getName(),"John Smith");
	}

	@Test
	public void testGetPassword() {
		int john = c.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401");
		c.setPassword("123abc");
		assertSame(c.getPassword(),"123abc");
	}

	@Test
	public void testGetAddress() {
		int john = c.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401");
		c.setAddress("2705 Heron Street");
		assertSame(c.getAddress(),"2705 Heron Street");
	}

	@Test
	public void testGetEmail() {
		int john = c.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401");
		c.setEmail("johnsmith@gmail.com");
		assertSame(c.getEmail(),"johnsmith@gmail.com");
	}

	@Test
	public void testGetPhone() {
		int john = c.regNewClient("John Smith", "123abc", "2705 Eagle Street","johnsmith@gmail.com","60188401");
		c.setPhone("60188401");
		assertSame(c.getPhone(),"60188401");
	}

}
