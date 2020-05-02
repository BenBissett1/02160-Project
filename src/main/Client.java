package main;

import java.util.List;

public class Client extends dataStructure {
	
	int clientID;
	String name;
	String password;
	String address;
	String email;
	String phone;
	
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
