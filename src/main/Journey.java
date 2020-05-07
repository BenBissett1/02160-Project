

package main;

import java.util.ArrayList;
import java.util.List;

/**
 * The methods used in the interface concerning the journey aspect of things are kept here. 
 * <p>
 * This class forms a journey, and the variables are easily accessed with "dataStructure.journeys.get(journeyID)"
 * which returns a journey object.
 * 
 * @since   2020-05-06 
 */
public class Journey extends dataStructure {

	private int journeyID;
	private String origin;
	private String destination;
	private String status;
	private String content;
	private String ClientID;
	private ArrayList<Float> temperatures = new ArrayList<Float>();
	private ArrayList<Float> humidity = new ArrayList<Float>();
	private ArrayList<Float> atmPressure = new ArrayList<Float>();
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
		return getTemperatures();
	}
	public List<Float> getHum() {
		return getHumidity();
	}
	public List<Float> getPres() {
		return getAtmPressure();
	}
	public Float getLastTemp() {
		if (getTemperatures().size()==0) {
			getTemperatures().add((float) (150 + Math.floor(Math.random() * (( 250 - 150 ) + 1 )))/10);
			return getTemperatures().get(0);
		}
		else {
			return getTemperatures().get(getTemperatures().size()-1);		
		}
	}
	public Float getLastHumidity() {
		if (getHumidity().size()==0) {
			getHumidity().add((float) (350 + Math.floor(Math.random() * (( 550 - 350 ) + 1 )))/10);
			return getHumidity().get(0);
		}
		else {
			return getHumidity().get(getHumidity().size()-1);	
		}
	}
	public Float getLastAtmPressure() {
		if (getAtmPressure().size()==0) {
			getAtmPressure().add((float) (9000 + Math.floor(Math.random() * (( 12000 - 9000 ) + 1 )))/10);
			return getAtmPressure().get(0);
		}
		else {
			return getAtmPressure().get(getAtmPressure().size()-1);
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
			
			j.getTemperatures().add(temp);
			j.getHumidity().add(hum);
			j.getAtmPressure().add(pres);
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
	void tempAdd(Float s) {
		this.getTemperatures().add(s);
	}
	void humAdd(Float s) {
		this.getHumidity().add(s);
	}
	void presAdd(Float s) {
		this.getAtmPressure().add(s);
	}
	int tempSize() {
		return this.getTemperatures().size();
	}
	int humSize() {
		return this.getHumidity().size();
	}
	int presSize() {
		return this.getAtmPressure().size();
	}
	public ArrayList<Float> getAtmPressure() {
		return atmPressure;
	}
	public void setAtmPressure(ArrayList<Float> atmPressure) {
		this.atmPressure = atmPressure;
	}
	public ArrayList<Float> getHumidity() {
		return humidity;
	}
	public void setHumidity(ArrayList<Float> humidity) {
		this.humidity = humidity;
	}
	public ArrayList<Float> getTemperatures() {
		return temperatures;
	}
	public void setTemperatures(ArrayList<Float> temperatures) {
		this.temperatures = temperatures;
	}
	
	
}