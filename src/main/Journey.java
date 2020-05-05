/**
* @since   2020-05-06 
*/

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
	public static List<Integer> searchJ(String keyword, int type, int cID) {
		List<Integer> journeyIDs = new ArrayList<Integer>();
		for (int i = Integer.parseInt(cID+""+journeysSize); i<Integer.parseInt(cID+""+2*journeysSize); i++) {
			if (journeys.get(i) == null) {continue;}
			if (type == 0) {
				if (keyword.equals(journeys.get(i).origin)) {
					journeyIDs.add(i);
				}
			}
			if (type == 1) {
				if (keyword.equals(journeys.get(i).destination)) {
					journeyIDs.add(i);
				}
			}
			if (type == 2) {
				if (keyword.equals(journeys.get(i).status)) {
					journeyIDs.add(i);
				}
			}
			if (type == 3) {
				if (keyword.equals(journeys.get(i).content)) {
					journeyIDs.add(i);
				}
			}
			if (type == 4) {
				if (keyword.equals(journeys.get(i).ClientID)) {
					journeyIDs.add(i);
				}
			}
		}
		return journeyIDs;
	}
	public static int regNewJourney(String origin, String destination, String content, int ClientID) {
		Journey j = new Journey();
		j.origin=origin;
		j.destination=destination;
		j.status="Origin";
		j.content=content;
		j.ClientID=""+ClientID;
		int jID=Integer.parseInt(ClientID+""+generate(journeysSize, 2));
		journeys.put(jID, j);
		return jID;
	}
	public static void updateJourney(int ID, String destination, String status) {
		Journey j = journeys.get(ID);
		j.destination=destination;
		j.status=status;
		journeys.put(ID, j);		
	}
	public static boolean journeyExists(int jID) {return !(journeys.get(jID)==null);}
	
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
	
	//Journey journey;
	/**
	 * Updates one value for each internal status parameter for a certain container.
	 * @param journeyID integer specific id for this journey.
	 * @param temp float temperature [celsius]
	 * @param hum float humidity [g/m3]
	 * @param pres float pressure [atm]
	 */
	
	public void updateContainerStatus(int journeyID,float temp, float hum, float pres) {
		if (dataStructure.journeys.get(journeyID) != null) {
			Journey j = dataStructure.journeys.get(journeyID);
			
			j.temperatures.add(temp);
			j.humidity.add(hum);
			j.atmPressure.add(pres);
		} else {
			System.out.println("UPDATE FAILED!");
		}
		
	}

	public boolean doesJourneyExist() {
		if (dataStructure.journeys.containsKey(journeyID)) {
//			journey = dataStructure.journeys.get(journeyID);
			//dataStructure.journeys.get(journeyID);
			return true;
		} else {
			return false;
		}
	}
	
}