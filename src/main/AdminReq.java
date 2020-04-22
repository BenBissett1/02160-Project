package main;

import java.util.List;

public class AdminReq {
	int journeyID;
	String thisData;
	List<List<String>> list = dataStructure.journeys.get(journeyID);
	int reqIndex;

	public String getThisData() {
		return thisData;
	}

	public void setThisData(String thisData) {
		this.thisData = thisData;
	}

	public int getJourneyID() {
		return journeyID;
	}

	public void setJourneyID(int journeyID) {
		this.journeyID = journeyID;
	}
	
	public boolean doesJourneyExist() {
		return dataStructure.journeys.containsKey(journeyID);
	}
	
	public boolean listNotEmpty() {
			
		if (thisData.equals("humidity")) {
			reqIndex = 1;
			catchOutofBounds(1);
			return true;
		} else if (thisData.equals("pressure")) {
			reqIndex = 2;
			catchOutofBounds(2);
			return true;
		} else if (thisData.equals("temperature")) {
			reqIndex = 3;
			catchOutofBounds(3);
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean catchOutofBounds(int index) {		
		try {
			list.get(index);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public void addData(List<String> data) {
		dataStructure.journeys.get(journeyID).get(reqIndex).addAll(data);
	}

}
