package main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class dataStructure {
	
	boolean isCompleteDataSet;
	Container container2 = new Container();
	
	
	public static int generate(int max, int type) {
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
	
	/*public static ResponseObject register(Client client, Port port, Container container) {
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
	}*/
	
	public static ResponseObject position(Container container) {
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
	
	
	
	static int clientsSize = 1000;
	static int journeysSize = 100000;
	public static Map<Integer, Client> clients= new HashMap<Integer, Client>();
	public static Map<Integer, Journey> journeys= new HashMap<Integer, Journey>();
	public static int searchC(String keyword, int type) {
		for (int i =clientsSize; i<2*clientsSize; i++) {
			if (type == 0) {
				if (clients.get(i) == null || clients.get(i).name.equals("")) {continue;}
				if (keyword.equals(clients.get(i).name)) {
					return i;}
			}
			if (type == 2) {
				if (clients.get(i) == null || clients.get(i).address.equals("")) {continue;}
				if (keyword.equals(clients.get(i).address)) {
					return i;}
			}
			if (type == 3) {
				if (clients.get(i) == null || clients.get(i).email.equals("")) {continue;}
				if (keyword.equals(clients.get(i).email)) {
					return i;}
			}
			if (type == 4) {
				if (clients.get(i) == null || clients.get(i).phone.equals("")) {continue;}
				if (keyword.equals(clients.get(i).phone)) {
					return i;}
			}
		}
		return -1;
	} 
	public static List<Integer> searchJ(String keyword, int type, int cID) {
		List<Integer> journeyIDs = new ArrayList<Integer>();
		System.out.println(journeys);
		for (int i = Integer.parseInt(cID+""+journeysSize); i<Integer.parseInt(cID+""+2*journeysSize); i++) {
			if (type == 0) {
				if (journeys.get(i) == null || journeys.get(i).origin.equals("")) {continue;}
				if (keyword.equals(journeys.get(i).origin)) {
					journeyIDs.add(i);
				}
			}
			if (type == 1) {
				if (journeys.get(i) == null || journeys.get(i).destination.equals("")) {continue;}
				if (keyword.equals(journeys.get(i).destination)) {
					journeyIDs.add(i);
				}
			}
			if (type == 2) {
				if (journeys.get(i) == null || journeys.get(i).status.equals("")) {continue;}
				if (keyword.equals(journeys.get(i).status)) {
					journeyIDs.add(i);
				}
			}
			if (type == 3) {
				if (journeys.get(i) == null || journeys.get(i).content.equals("")) {continue;}
				if (keyword.equals(journeys.get(i).content)) {
					journeyIDs.add(i);
				}
			}
			if (type == 4) {
				if (journeys.get(i) == null || journeys.get(i).ClientID.equals("")) {continue;}
				if (keyword.equals(journeys.get(i).ClientID)) {
					journeyIDs.add(i);
				}
			}
		}
		return journeyIDs;
	}
	public static int regNewClient(String name, String password, String address, String email, String phone) {
		Client c = new Client();
		c.name=name;
		c.password=password;
		c.address=address;
		c.email=email;
		c.phone=phone;
		if (searchC(name, 0) !=-1 | searchC(address, 2) !=-1 | searchC(email, 3) != -1 | searchC(phone, 4) != -1) {
			return -1;
		}
		else {
			int cID = generate(clientsSize, 1);
			clients.put(cID, c);
			return cID;
		}
	}
	public static int regNewJourney(String origin, String destination, String content, int ClientID) {
		Journey j = new Journey();
		j.origin=origin;
		j.destination=destination;
		j.status="Preparing for departure";
		j.content=content;
		j.ClientID=""+ClientID;
		if (clients.get(ClientID)==null) {
			return -1;
		}
		else {
			int jID=Integer.parseInt(ClientID+""+generate(journeysSize, 2));
			journeys.put(jID, j);
			return jID;
		}
	}
	public static void updateClient(int ID, String name, String password, String address, String email, String phone) {
		Client c = new Client();
		c.name=name;
		c.password=password;
		c.address=address;
		c.email=email;
		c.phone=phone;
		clients.put(ID,c);	
	}
	public static void updateJourney(int ID, String destination, String status) {
		Journey j = journeys.get(ID);
		j.destination=destination;
		j.status=status;
		journeys.put(ID, j);		
	}
	public static void save() {
		String serialClients = "";
		Iterator<Integer> itr = clients.keySet().iterator();
		while(itr.hasNext()) {
			int i = itr.next();
			serialClients+="<"+clients.get(i).name+"|"+clients.get(i).password+"|"+clients.get(i).address+"|"+clients.get(i).email+"|"+clients.get(i).phone+">\n";
		}
		System.out.println("wtf:"+serialClients);
		try {BufferedWriter out = new BufferedWriter(new FileWriter("clients.txt"));
		out.write(serialClients);
		out.close();
		}
		catch (Exception c) {}
	}
	public static void load() {
//		try {BufferedReader br = new BufferedReader(new FileReader("clients.txt"));
//		String 
//		}
		}
	public static boolean clientExists(int cID) {
		if (clients.get(cID)==null) {
			return false;
		}
		else {
			return true;
		}
	}
	public static boolean journeyExists(int jID) {
		if (journeys.get(jID)==null) {
			return false;
		}
		else {
			return true;
		}
	}
	public static void main(String[] args) {
		load();
		System.out.println(clients.get(1692));
		System.out.println(regNewClient("Ben","Ben","Ben","Ben","Ben"));
		System.out.println(searchC("Ben",0));
		save();
	}
}