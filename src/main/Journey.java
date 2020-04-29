package main;

import java.util.ArrayList;
import java.util.List;

public class Journey extends dataStructure {

	int journeyID;
	String origin;
	String destination;
	String status;
	String content;
	String ClientID;
	ArrayList<Float> temperatures = new ArrayList<Float>();
	ArrayList<Float> humidity = new ArrayList<Float>();
	ArrayList<Float> atmPressure = new ArrayList<Float>();
	public List<Float> getTemp() {
		return temperatures;
	}
	public List<Float> getHum() {
		return humidity;
	}
	public List<Float> getPres() {
		return atmPressure;
	}
	public Float getLastTemp() {
		if (temperatures.size()==0) {
			temperatures.add((float) (150 + Math.floor(Math.random() * (( 250 - 150 ) + 1 )))/10);
			return temperatures.get(0);
		}
		else {
			return temperatures.get(temperatures.size()-1);		
		}
	}
	public Float getLastHumidity() {
		if (humidity.size()==0) {
			humidity.add((float) (350 + Math.floor(Math.random() * (( 550 - 350 ) + 1 )))/10);
			return humidity.get(0);
		}
		else {
			return humidity.get(humidity.size()-1);	
		}
	}
	public Float getLastAtmPressure() {
		if (atmPressure.size()==0) {
			atmPressure.add((float) (9000 + Math.floor(Math.random() * (( 12000 - 9000 ) + 1 )))/10);
			return atmPressure.get(0);
		}
		else {
			return atmPressure.get(atmPressure.size()-1); 
		}
	}
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
	public String getClientID() {
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
		this.ClientID=x;
	}
	
	
}
