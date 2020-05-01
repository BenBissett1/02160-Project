package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class request {
	int journeyID;
	String thisData;
	Journey journey;
	int reqIndex;

	public void setThisData(String thisData) {
		this.thisData = thisData;
	}

	public void setJourneyID(int journeyID) {
		this.journeyID = journeyID;
	}
	
	public boolean doesJourneyExist() {
		if (dataStructure.journeys.containsKey(journeyID)) {
			journey = dataStructure.journeys.get(journeyID);
			return true;
		} else {
			return false;
		}
	}
	
	public void updateContainerStatus(int journeyID,float temp, float hum, float pres) {
		this.journeyID = journeyID;
		doesJourneyExist();
		
		journey.temperatures.add(temp);
		journey.humidity.add(hum);
		journey.atmPressure.add(pres);
		
	}
	
	public ArrayList<Float> getHum() {
		return journey.humidity;
	}

	public ArrayList<Float> getPres() {
		return journey.atmPressure;
	}
	
	public ArrayList<Float> getTemp() {
		return journey.temperatures;
	}
	
	public void removeDataTemp(int index) {
		journey.temperatures.remove(index);
	}

	public void removeDataHum(int index) {
		journey.humidity.remove(index);
	}
	
	public void removeDataPres(int index) {
		journey.atmPressure.remove(index);
	}
}

