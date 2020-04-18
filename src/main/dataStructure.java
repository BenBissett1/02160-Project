package main;


import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Emmanuel Ryom (s184371)
class IDgen extends dataStructure{
	static int cIDgen() {
		int newID = 0;
		while(true) {
			newID = (int) (0 + Math.floor(Math.random() * (( clientsSize - 0 ) +1 )));
			if (clients.get(newID) == null) {
				return newID;
			}
		}
	}
}

public class dataStructure {
	static Map<Integer, List<String>> clients= new HashMap<Integer, List<String>>();
	// Map structure [client id, [name, password, address, email, phone]]
	//                              0      1         2       3      4
	static int clientsSize = 1000;
	public static int search(String keyword, int type) {
		for (int i =0; i<clientsSize; i++) {
			if (clients.get(i) == null || clients.get(i).get(0).equals("")) {continue;}
			if (keyword.equals(clients.get(i).get(type))) {
				return i;
			}
		}
		return -1;
	}
	public static void regNewClient(String name, String password, String address, String email, String phone) {
		ArrayList<String> vars = new ArrayList<String>();
		vars.add(name);
		vars.add(password);
		vars.add(address);
		vars.add(email);
		vars.add(phone);
		if (search(name, 0) !=-1 | search(address, 2) !=-1 | search(email, 3) != -1 | search(phone, 4) != -1) {
			
		}
		if (name.equals("") | password.equals("") | address.equals("") | email.equals("") | phone.equals("")) {
			
		}
		else {
			clients.put(IDgen.cIDgen(), vars);		
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
//	public static void main(String[] args) {
//		System.out.println(clients.size());
//		ArrayList<String> test =  new ArrayList<String>() ;
//		test.add("John&co");
//		test.add("Snow");
//		test.add("275 Brookmere rd");
//		test.add("John89@johnco.com");
//		test.add("123456");
//		clients.put(IDgen.cIDgen(), test);
//		System.out.println(clients.get(search("John&co",0)));
//	}
}
