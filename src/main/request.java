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
		if (doesJourneyExist()) {
			journey.temperatures.add(temp);
			journey.humidity.add(hum);
			journey.atmPressure.add(pres);
		}
	}

	public ArrayList<Float> getHum(int journeyID) {
		this.journeyID = journeyID;
		if (doesJourneyExist()) {
			return journey.humidity;
		}
		return null;
	}
	
	public ArrayList<Float> getPres(int journeyID) {
		this.journeyID = journeyID;
		if (doesJourneyExist()) {
			return journey.atmPressure;
		}
		return null;
	}
	
	public ArrayList<Float> getTemp(int journeyID) {
		this.journeyID = journeyID;
		if (doesJourneyExist()) {
			return journey.temperatures;
		}
		return null;
	}
}

