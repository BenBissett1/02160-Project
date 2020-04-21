package main;

public class Journey {

	int journeyID;
	String origin;
	String destination;
	String status;
	String content;
	int ClientID;
	public int getJID() {
		return journeyID;
	}
	public String getDestination() {
		return destination;
	}
	public String getStatus() {
		return status;
	}
	public String getOrigin() {
		return origin;
	}
	public String getContent() {
		return content;
	}
	public int getClientID() {
		return ClientID;
	}
	public void setJID(int jID) {
		this.journeyID=jID;
	}
	public void setStatus(String x) {
		this.status=x;
	}
	public void setDestination(String x) {
		this.destination=x;
	}
	public void setOrigin(String x) {
		this.origin=x;
	}
	public void setContent(String x) {
		this.content=x;
	}
	public void setClientID(String x) {
		this.ClientID=Integer.parseInt(x);
	}
	
	
}
