package main;

public class Client {
	
	String name;
	boolean isRegistered;

	public Client() {
		super();
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

	public void setRegistered (boolean isRegistered) {
		this.isRegistered = isRegistered;
		
	}

}
