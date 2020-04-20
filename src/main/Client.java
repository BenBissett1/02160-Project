package main;

public class Client {
	
	Database data = new Database();
	
	int clientID;
	String name;
	String password;
	String address;
	String email;
	String phone;
	
	boolean isRegistered;

	public Client() {
		super();
	}
	
	public int getID() {
		return clientID;
	}
	public void setID(int clientID) {
		this.clientID = clientID;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isRegistered() {
		return isRegistered;
	}

	public Database getData() {
		return data;
	}

	public void setData(Database data) {
		this.data = data;
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

	public void setRegistered (boolean isRegistered) {
		this.isRegistered = isRegistered;
		
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
	public void register( ) {
		data.regNewClient(name, password, address, email, phone, 0);
	}
	public void display() {
		System.out.println(data.searchC(name, 0));
	}
	
	
	
	
	
	
	

}
