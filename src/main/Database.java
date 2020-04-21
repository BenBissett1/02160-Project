package main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
class IDgen2 extends Database {
	int generate(int max, int type) {
		int newID = 0;
		while(true) {
			newID = (int) (max + 0 + Math.floor(Math.random() * (( max - 0 ) +1 )));
			if (type == 1) {
				if (clients.get(newID) == null) {
					return newID;
				}
			}
			if (type == 2) {
				if (journeys.get(newID) == null) {
					return newID;
				}
			}
		}
	}
}*/



public class Database {
	
	boolean isCompleteDataSet;
	Container container2 = new Container();
	
	
	public int generate(int max, int type) {
		int newID = 0;
		while(true) {
			newID = (int) (max + 0 + Math.floor(Math.random() * (( max - 0 ) +1 )));
			if (type == 1) {
				if (clients.get(newID) == null) {
					return newID;
				}
			}
			if (type == 2) {
				if (journeys.get(newID) == null) {
					return newID;
				}
			}
		}
	}
	
	
	
	
	
	public ResponseObject register(Client client, Port port, Container container) {
		ResponseObject response;
		if (!container.isRegistered()) {
			
			if (port.getLocationInitial().equals("")
					|| port.getLocationFinal().equals("")
					|| container.getContent().equals("")) {
				response = new ResponseObject(220, "Registration unsuccessful");
			} else {
				container.setRegistered(true);
				response = new ResponseObject(200, "Registration successful");
			}
		} else {
			response = new ResponseObject(210, "Already registered");
		}
		return response;
	}
	
	public ResponseObject position(Container container) {
		ResponseObject response;
		
		if (container.getJourneyID() < 1000) {
			response = new ResponseObject(320, "Container not found");
		} else {
			if (container.isEnroute()) {
				response = new ResponseObject(310, "Container enroute");
			} else {
				response = new ResponseObject(300, "Container arrived");
			}
		}
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public boolean isClientCompleteDataSet(int clientID) {
		List<String> list = clients.get(clientID);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == "") return false;
		}
		return true;
	}
	public boolean isJourneyCompleteDataSet(int journeyID) {
		List<String> list = journeys.get(journeyID).get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == "") return false;
		}
		return true;
	}
	
	
	int journeyIDSpaceHolder = 0;
	
	

	public static Map<Integer, List<String>> clients= new HashMap<Integer, List<String>>();
	// Map structure [client id, [name, password, address, email, phone]]
	//                              0      1         2       3      4
	public static Map<Integer, List<List<String>>> journeys= new HashMap<Integer, List<List<String>>>();
	// Map structure [Journey ID, [[origin, destination, status,  content, ClientID], [val1 list], [val2 list], [val3 list]]]
	//                                00         01         02       03       04          10           20           30
	int clientsSize = 1000;
	int journeysSize = 100000;
	public int searchC(String keyword, int type) {
		for (int i =0; i<clientsSize; i++) {
			if (clients.get(i) == null || clients.get(i).get(0).equals("")) {continue;}
			if (keyword.equals(clients.get(i).get(type))) {
				return i;
			}
		}
		return -1;
	}
	public List<Integer> searchJ(String keyword, int type, int cID) {
		List<Integer> journeyIDs = new ArrayList<Integer>();
		System.out.println(journeys);
		for (int i = Integer.parseInt(cID+""+journeysSize); i<Integer.parseInt(cID+""+2*journeysSize); i++) {
			if (journeys.get(i) == null || journeys.get(i).get(0).get(0).equals("")) {continue;}
			if (keyword.equals(journeys.get(i).get(0).get(type))) {
				journeyIDs.add(i);
			}
		}
		return journeyIDs;
	}
	public int regNewClient(String name, String password, String address, String email, String phone, int journeyIDSpaceHolder) {
		ArrayList<String> vars = new ArrayList<String>();
		vars.add(name);
		vars.add(password);
		vars.add(address);
		vars.add(email);
		vars.add(phone);
		//vars.add("" + journeyIDSpaceHolder);
		if (searchC(name, 0) !=-1 | searchC(address, 2) !=-1 | searchC(email, 3) != -1 | searchC(phone, 4) != -1) {
			return -1;
		}
		else {
			int cID = generate(clientsSize, 1);
			clients.put(cID, vars);
			return cID;
		}
	}
	public int regNewJourney(String origin, String destination, String content, int clientID) {
		ArrayList<String> vars = new ArrayList<String>();
		vars.add(origin);
		vars.add(destination);
		vars.add("Preparing for departure");
		vars.add(content);
		vars.add(""+clientID);
		List<List<String>> vars2 = new ArrayList<List<String>>();
		vars2.add(vars);
		if (origin.equals("") | destination.equals("") | content.equals("") | clients.get(clientID)==null ) {
			return -1;
		}
		else {
			int jID=Integer.parseInt(clientID+""+generate(journeysSize, 2));
			journeys.put(jID, vars2);
			return jID;
		}
	}
	public void updateClient(int ID, String name, String password, String address, String email, String phone, int journeyIDs) {
		ArrayList<String> vars = new ArrayList<String>();
		vars.add(name);
		vars.add(password);
		vars.add(address);
		vars.add(email);
		vars.add(phone);
		clients.put(ID,vars);
	}
	public void updateJourney(int ID, String origin, String destination, String status, String content, String cID) {
		ArrayList<String> vars = new ArrayList<String>();
		vars.add(origin);
		vars.add(destination);
		vars.add(status);
		vars.add(content);
		vars.add(""+cID);
		List<List<String>> vars2 = new ArrayList<List<String>>();
		vars2.add(vars);
		journeys.put(ID, vars2);
		//journeys.replace(ID, vars2);
	}
	public static void saveC() {
		try {
	        File file=new File("clients");
	        FileOutputStream fos=new FileOutputStream(file);
	        ObjectOutputStream oos=new ObjectOutputStream(fos);

	        oos.writeObject(clients);
	        oos.flush();
	        oos.close();
	        fos.close();
	    } catch(Exception e) {}
	}
	public static void loadC() {
		try {
	        File toRead=new File("clients");
	        FileInputStream fis=new FileInputStream(toRead);
	        ObjectInputStream ois=new ObjectInputStream(fis);

	        clients=(HashMap<Integer, List<String>>)ois.readObject();

	        ois.close();
	        fis.close();
	    } catch(Exception e) {}
	}
	public static void saveJ() {
		try {
	        File file=new File("journeys");
	        FileOutputStream fos=new FileOutputStream(file);
	        ObjectOutputStream oos=new ObjectOutputStream(fos);

	        oos.writeObject(journeys);
	        oos.flush();
	        oos.close();
	        fos.close();
	    } catch(Exception e) {}
	}
	public static void loadJ() {
		try {
	        File toRead=new File("journeys");
	        FileInputStream fis=new FileInputStream(toRead);
	        ObjectInputStream ois=new ObjectInputStream(fis);

	        journeys=(HashMap<Integer, List<List<String>>>)ois.readObject();

	        ois.close();
	        fis.close();
	    } catch(Exception e) {}

	}
}
	
//	public static void main(String[] args) {
//	long startTime = System.nanoTime();
//	loadC();
//	System.out.println(clients);
//	loadJ();
//	System.out.println(searchJ("Dildos",3,1679));
//	long endTime = System.nanoTime();
//	long timeElapsed = endTime - startTime;
//	System.out.println("Execution time in seconds  : " + timeElapsed);
//	System.out.println(journeys);
//	System.out.println(journeys.get(15731634).get(0).get(3));
//	System.out.println(journeys.get(searchJ("Dildos",3).get(0)).get(0));		
//	int johnsID = regNewClient("Johnny&co","Snow132","276 Brookmere rd","John99@johnco.com","123466");
//	int johnjourney = regNewJourney("Your mom","Swedes","Dildos",johnsID);
//	saveC();
//	saveJ();
//	System.out.println(johnsID);
//	save();
//	System.out.println(clients.size());
//	
//}
