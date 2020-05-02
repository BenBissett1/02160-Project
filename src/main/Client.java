package main;

import java.util.List;

public class Client extends dataStructure {
	
	int clientID;
	String name;
	String password;
	String address;
	String email;
	String phone;
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
	public static void updateClient(int ID, String name, String password, String address, String email, String phone) {
		Client c = new Client();
		c.name=name;
		c.password=password;
		c.address=address;
		c.email=email;
		c.phone=phone;
		clients.put(ID,c);	
	}
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
