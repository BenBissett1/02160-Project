package main;

import java.util.List;


/**
 * The methods used in the interface concerning the client aspect of things are kept here. 
 * <p>
 * This class forms a client, and the variables are easily accessed with "dataStructure.clients.get(clientID)"
 * which returns a client object.
 * 
 * @since   2020-05-06 
 */

public class Client extends dataStructure {
	int clientID;
	String name;
	String password;
	String address;
	String email;
	String phone;
	
	/**
	 * Searches for client information with String keyword (a client name) and integer type to clarify what type of information.
	 * <p>
	 * 0, name <p>
	 * 2, address <p>
	 * 3, email <p>
	 * 4, phone number
	 * @param keyword String of the name/address/phone number/email that is searched for.
	 * @param type integer specifying type of client information.
	 * @return returns index if search was successful otherwise returns -1.
	 */
	
	public static int searchC(String keyword, int type) {
		for (int i =clientsSize; i<2*clientsSize; i++) {
			if (clients.get(i) == null) {continue;}
			if (type == 0) {
				if (keyword.equals(clients.get(i).name)) {return i;}
			}
			if (type == 2) {
				if (keyword.equals(clients.get(i).address)) {return i;}
			}
			if (type == 3) {
				if (keyword.equals(clients.get(i).email)) {return i;}
			}
			if (type == 4) {
				if (keyword.equals(clients.get(i).phone)) {return i;}
			}
		}
		return -1;
	} 
	
	/**
	 * Registers a new client, but will fail either if name/address/email/phone number has been used before.
	 * @param name String name
	 * @param password String password
	 * @param address String address
	 * @param email String email
	 * @param phone String phone number
	 * @return If successful register return randomly generated client ID otherwise return -1.
	 */
	
	
	public static int regNewClient(String name, String password, String address, String email, String phone) {
		Client c = new Client();
		c.name=name;
		c.password=password;
		c.address=address;
		c.email=email;
		c.phone=phone;
		if (searchC(name, 0) !=-1 | searchC(address, 2) !=-1 | searchC(email, 3) != -1 | searchC(phone, 4) != -1) {
			return -1;
		}
		else {
			int cID = generate(clientsSize, 1);
			clients.put(cID, c);
			return cID;
		}
	}
	
	/**
	 * Updates client information.
	 * @param ID integer ID
	 * @param name String name
	 * @param password String password
	 * @param address String address
	 * @param email String email
	 * @param phone String phone
	 */
	
	public static void updateClient(int ID, String name, String password, String address, String email, String phone) {
		Client c = new Client();
		c.name=name;
		c.password=password;
		c.address=address;
		c.email=email;
		c.phone=phone;
		clients.put(ID,c);	
	}
	
	/**
	 * Checks if client exists.
	 * @param cID integer client ID
	 * @return returns boolean.
	 */
	
	public static boolean clientExists(int cID) {return !(clients.get(cID)==null);}
	
	public int getID() {
		return clientID;
	}
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setID(int id) {
		clientID=id;
		
	}
}
