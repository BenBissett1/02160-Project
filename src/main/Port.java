package main;


public class Port {
	
	String locationInitial;
	String locationFinal;
	boolean isRegistered;
	String journey = locationInitial + " -> " + locationFinal;

	public String getJourney() {
		return journey;
	}

	public void setJourney(String journey) {
		this.journey = journey;
	}

	public Port() {
		super();
	}

	public String getLocationInitial() {
		return locationInitial;
	}

	public void setLocationInitial(String location) {
		this.locationInitial = location;
	}
	
	public String getLocationFinal() {
		return locationFinal;
	}

	public void setLocationFinal(String location) {
		this.locationFinal = location;
	}
	
	
	
	public boolean isRegistered() {
		return isRegistered;
	}

	public void setRegistered (boolean isRegistered) {
		this.isRegistered = isRegistered;
		
	}
	
}
