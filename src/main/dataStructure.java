package main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

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
	
	public static ResponseObject register(Client client, Port port, Container container) {
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
	
	
	
	public static ArrayList<Client> clients= new ArrayList<Client>();
	public static ArrayList<Journey> journeys= new ArrayList<Journey>();
	static int clientsSize = 1000;
	static int journeysSize = 100000;
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
//		System.out.println(journeys);
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
			clients.set(cID, c);
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
			journeys.set(jID, j);
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
		clients.set(ID,c);	
	}
	public static void updateJourney(int ID, String origin, String destination, String status, String content, String cID) {
		Journey j = new Journey();
		j.origin=origin;
		j.destination=destination;
		j.status="Preparing for departure";
		j.content=content;
		j.ClientID=""+cID;
		journeys.set(ID, j);		
	}
	public static void save() {
		try {
	        File file=new File("clients");
	        FileOutputStream fos=new FileOutputStream(file);
	        ObjectOutputStream oos=new ObjectOutputStream(fos);
	        oos.writeObject(clients);
	        oos.flush();
	        oos.close();
	        fos.close();
	    } catch(Exception e) {}
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
	public static void load() {
		try {
	        File toRead=new File("clients");
	        FileInputStream fis=new FileInputStream(toRead);
	        ObjectInputStream ois=new ObjectInputStream(fis);
	        clients=(ArrayList<Client>)ois.readObject();
	        ois.close();
	        fis.close();
	    } catch(Exception e) {}
		try {
	        File toRead=new File("journeys");
	        FileInputStream fis=new FileInputStream(toRead);
	        ObjectInputStream ois=new ObjectInputStream(fis);
	        journeys=(ArrayList<Journey>)ois.readObject();
	        ois.close();
	        fis.close();
	    } catch(Exception e) {}
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

}