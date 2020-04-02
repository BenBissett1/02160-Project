

import java.util.ArrayList;

// Emmanuel Andr� Ryom (s184371)
class client extends dataStructure{
	String Name;
	int cID;
	String Address;
	String Email;
	int Phone;
}

class IDgen extends dataStructure{
	public static int cIDgen(ArrayList<client> cs) {
		boolean copy = true;
		int newID = 0;
		while(copy==true) {
			copy = false;
			newID = (int) (0 + Math.floor(Math.random() * (( clientsSize - 0 ) +1 )));
			for (int i = 0; i < cs.size(); i++) {
				if (cs.get(i).cID==newID) {
					copy = true;
				}
			}			
		}
		return newID;
	}
}

public class dataStructure {
	static ArrayList<client> clients= new ArrayList<client>();
	static int clientsSize = 1000;
	static int searchName(String n) {
		for (int i =0; i<clientsSize; i++) {
			if (n.equals(clients.get(i).Name)) {
				return i;
			}
		}
		return -1;
	}
	static int searchAddress(String n) {
		for (int i =0; i<clientsSize; i++) {
			if (n.equals(clients.get(i).Address)) {
				return i;
			}
		}
		return -1;
	}
	static int searchEmail(String n) {
		for (int i =0; i<clientsSize; i++) {
			if (n.equals(clients.get(i).Email)) {
				return i;
			}
		}
		return -1;
	}
	static int searchPhone(int n) {
		for (int i =0; i<clientsSize; i++) {
			if (clients.get(i).Phone==n) {
				return i;
			}
		}
		return -1;
	}
	static void regNewClient(String name, String address, String email, int phone) {
		client c = new client();
		c.Name = name;
		c.Address = address;
		c.Email = email;
		c.Phone = phone;
		c.cID = IDgen.cIDgen(clients);
		clients.set(c.cID,c);	
	}
	public static void main(String[] args) {
		for (int i =0; i<clientsSize; i++) {
			clients.add(new client());
		}		
	}
}
