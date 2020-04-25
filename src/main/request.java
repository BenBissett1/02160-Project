package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class request {
	int journeyID;
	String thisData;
	List<List<String>> list = dataStructure.journeys.get(journeyID);
	int reqIndex;

	public void setThisData(String thisData) {
		this.thisData = thisData;
	}

	public void setJourneyID(int journeyID) {
		this.journeyID = journeyID;
	}
	
	public boolean doesJourneyExist() {
		return dataStructure.journeys.containsKey(journeyID);
	}
	
	public boolean listNotEmpty() {
			
		if (thisData.equals("humidity") && list.get(1) != null) {
			reqIndex = 1;
			//catchOutofBounds(1);
			return true;
		} else if (thisData.equals("pressure") && list.get(2) != null) {
			reqIndex = 2;
			//catchOutofBounds(2);
			return true;
		} else if (thisData.equals("temperature") && list.get(3) != null) {
			reqIndex = 3;
			//catchOutofBounds(3);
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
		list.get(reqIndex).addAll(data);
	}
	
	public List<String> getData() {
		return list.get(reqIndex);
	}
	
	public void removeData(int removeThisData) {
		list.get(reqIndex).remove(removeThisData);
	}

}
