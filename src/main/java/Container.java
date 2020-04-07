import java.util.ArrayList;
import java.util.Scanner;

public class Container {
	String containerID;
	String journey;
	String specificID = containerID + "," + journey;	
	
	//Take input and store data
	ArrayList<Integer> pressureList = new ArrayList<Integer>();
	ArrayList<Integer> humList = new ArrayList<Integer>();
	ArrayList<Integer> tempList = new ArrayList<Integer>(); 
	
	int pressure;
	int hum;
	int temp;
	
	String holdID1;
	String holdID2;
	String holdID3;
	
	ArrayList<Integer> outPressure;
	ArrayList<Integer> outTemp;
	ArrayList<Integer> outHum;
	ArrayList<Integer> random;
	
	
	public void setContainerID(String containerID) {
		this.containerID = containerID;
	}


	public void setJourney(String journey) {
		this.journey = journey;
	}

	
	public void getExpandedSpecificIDAll(String specificID) {
		holdID1 = specificID + "," + "pressure";
		holdID2 = specificID + "," + "hum";
		holdID3 = specificID + "," + "temp";
	}
	
	public String createExpandedSpecificID(String dataType) {
		return specificID + "," + dataType;
	}
	
	public void setData() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 'exit' when no more data");
		
		// For some reason requires input before actual data
		// Gives yellow when run with coverage, find alternative while statement
		while (sc.hasNext() && !(sc.next()).equals("exit")) {
			System.out.println("Temperature: ");
			temp = sc.nextInt();
			tempList.add(temp);
			System.out.println("Humidity: ");
			hum = sc.nextInt();
			humList.add(hum);
			System.out.println("Pressure: ");
			pressure = sc.nextInt();
			pressureList.add(pressure);
		}
		sc.close();
	}
}


