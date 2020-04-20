package main;

/*
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Emmanuel Ryom (s184371)
class IDgen extends dataStructure{
	static int generate(int max, int type) {
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
}

public class dataStructure {
	public static Map<Integer, List<String>> clients= new HashMap<Integer, List<String>>();
	// Map structure [client id, [name, password, address, email, phone]]
	//                              0      1         2       3      4
	static Map<Integer, List<List<String>>> journeys= new HashMap<Integer, List<List<String>>>();
	// Map structure [Journey ID, [[origin, destination, status,  content, ClientID], [val1 list], [val2 list], [val3 list]]]
	//                                00         01         02       03       04          10           20           30
	static int clientsSize = 1000;
	static int journeysSize = 100000;
	public static int searchC(String keyword, int type) {
		for (int i =0; i<clientsSize; i++) {
			if (clients.get(i) == null || clients.get(i).get(0).equals("")) {continue;}
			if (keyword.equals(clients.get(i).get(type))) {
				return i;
			}
		}
		return -1;
	}
	public static List<Integer> searchJ(String keyword, int type, int cID) {
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
	public static int regNewClient(String name, String password, String address, String email, String phone) {
		ArrayList<String> vars = new ArrayList<String>();
		vars.add(name);
		vars.add(password);
		vars.add(address);
		vars.add(email);
		vars.add(phone);
		if (searchC(name, 0) !=-1 | searchC(address, 2) !=-1 | searchC(email, 3) != -1 | searchC(phone, 4) != -1) {
			return -1;
		}
		else {
			int cID = IDgen.generate(clientsSize, 1);
			clients.put(cID, vars);
			return cID;
		}
	}
	public static int regNewJourney(String origin, String destination, String content, int ClientID) {
		ArrayList<String> vars = new ArrayList<String>();
		vars.add(origin);
		vars.add(destination);
		vars.add("Preparing for departure");
		vars.add(content);
		vars.add(""+ClientID);
		List<List<String>> vars2 = new ArrayList<List<String>>();
		vars2.add(vars);
		if (origin.equals("") | destination.equals("") | content.equals("") | clients.get(ClientID)==null ) {
			return -1;
		}
		else {
			int jID=Integer.parseInt(ClientID+""+IDgen.generate(journeysSize, 2));
			journeys.put(jID, vars2);
			return jID;
		}
	}
	public static void updateClient(int ID, String name, String password, String address, String email, String phone) {
		ArrayList<String> vars = new ArrayList<String>();
		vars.add(name);
		vars.add(password);
		vars.add(address);
		vars.add(email);
		vars.add(phone);
		clients.put(ID,vars);	
	}
	public static void updateJourney(int ID, String origin, String destination, String status, String content, String cID) {
		ArrayList<String> vars = new ArrayList<String>();
		vars.add(origin);
		vars.add(destination);
		vars.add(status);
		vars.add(content);
		vars.add(""+cID);
		List<List<String>> vars2 = new ArrayList<List<String>>();
		vars2.add(vars);
		journeys.put(ID, vars2);		
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
*/