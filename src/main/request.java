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
		list.get(reqIndex).addAll(data);
	}
	
	public List<String> getData() {
		return list.get(reqIndex);
	}

}


//class testrun {
//	public static void main(String[] args) {
//		request request = new request();
//		
//		request.setJourneyID(1234);
//		request.setThisData("humidity");
//		List<List<String>> fakelist= new List<List<String>>(); 
//		
//		dataStructure.journeys.put(request.journeyID,);
//		
//		request.doesJourneyExist();
//		request.listNotEmpty();
//		request.addData(data);
//	}
//}



