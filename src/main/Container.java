package main;

public class Container {
	
	String content;
	boolean isRegistered;
	int identity;
	int[] position;
	boolean isValidContainerID;
	boolean isEnroute;
	int journeyID;

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}

	public int getJourneyID() {
		return identity;
	}

	public void setJourneyID(int identity) {
		this.identity = identity;
	}

	public Container() {
		super();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public boolean isRegistered() {
		return isRegistered;
	}
	public void setRegistered (boolean isRegistered) {
		this.isRegistered = isRegistered;
	}
	
	public boolean isValidContainerID() {
		return isValidContainerID;
	}
	public void setValidContainerID(boolean isValidContainerID) {
		this.isValidContainerID = isValidContainerID;
	}
	
	public boolean isEnroute() {
		return isEnroute;
	}
	public void setEnroute(boolean isEnroute) {
		this.isEnroute = isEnroute;
	}
	
	public int getJourney() {
		return journeyID;
	}

	public void setJourney(int journeyID) {
		this.journeyID = journeyID;
	}
	
	
}