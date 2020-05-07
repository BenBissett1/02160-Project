package main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * The dataStructure class holds all information used for the methods in Client and Journey.
 * <p>
 * The dataStructure class contains maps with information about clients and journeys
 * along with methods for generating data and save/load data into .txt files (clients.txt, companyPW.txt, journeys.txt)
 * 
 * @since 2020-05-06
 */

public class dataStructure {
	
	boolean isCompleteDataSet;
	
	/**
	 * Generate random identifier for either clients or journeys up to integer max.
	 * @param max integer specifies max value
	 * @param type integer specifies if it is a client or a journey.
	 * 1, client
	 * 2, journey
	 * @return returns integer client/journey ID.
	 */
	
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
	private static String companyPassword = "0000";
	
	/**
	 * Compares two Strings and returns true if match.
	 * @param s String password
	 * @return returns boolean.
	 */
	
    public static boolean companyPasswordMatch(String s) {
        return s.equals(companyPassword);
    }
    
    /**
     * If password, String op, matches current password then current password is changed to String np.
     * @param op String old password
     * @param np String new password
     * @return returns boolean, change complete true/false.
     */
    
    public static boolean changeCompanyPassword(String op, String np) {
    	if (companyPasswordMatch(op)) {
    		companyPassword = np;
    		try {BufferedWriter out = new BufferedWriter(new FileWriter("companyPW.txt"));
    		out.write(np);
    		out.close();
    		return true;
    		}
    		catch (Exception c) {System.out.println("PASSWORD SAVING FAILED");}
    	}
    	return false;
    }
	static int clientsSize = 1000;
	static int journeysSize = 100000;
	public static Map<Integer, Client> clients= new HashMap<Integer, Client>();
	public static Map<Integer, Journey> journeys= new HashMap<Integer, Journey>();
	public static List<Integer> allClients() {
		List<Integer> allCs = new ArrayList<Integer>();
		for (int i =clientsSize; i<2*clientsSize; i++) {
			if (clients.get(i) != null) {allCs.add(i);}
		}
		return allCs;
	}
	public static List<Integer> allJourneys() {
		List<Integer> allJs = new ArrayList<Integer>();
		List<Integer> allCs = allClients();
		for (int i =0; i<allCs.size(); i++) {
			allJs.addAll(Journey.searchJ(""+allCs.get(i),4,allCs.get(i)));
		}
		return allJs;
	}
	public static void save() {
		String serialClients = "";
		Iterator<Integer> itr = clients.keySet().iterator();
		while(itr.hasNext()) {
			int i = itr.next();
			serialClients+=i+"|"+clients.get(i).getName()+"|"+clients.get(i).getPassword()+"|"+clients.get(i).getAddress()+"|"+clients.get(i).getEmail()+"|"+clients.get(i).getPhone()+">\n";
		}
		try {BufferedWriter out = new BufferedWriter(new FileWriter("clients.txt"));
		out.write(serialClients+"End");
		out.close();
		}
		catch (Exception c) {System.out.println("CLIENT LIST SAVING FAILED");}
		String serialJourneys = "";
		itr = journeys.keySet().iterator();
		while(itr.hasNext()) {
			int i = itr.next();
			serialJourneys+=i+"|"+journeys.get(i).getOrigin()+"|"+journeys.get(i).getDestination()+"|"+journeys.get(i).getStatus()+"|"+journeys.get(i).getContent()+"|"+journeys.get(i).getClientID()+"|>";
			for (int u = 0; u<journeys.get(i).tempSize(); u++) {
				serialJourneys+=journeys.get(i).getTemperatures().get(u)+";";
			}
			serialJourneys+=">";
			for (int u = 0; u<journeys.get(i).humSize(); u++) {
				serialJourneys+=journeys.get(i).getHumidity().get(u)+";";
			}
			serialJourneys+=">";
			for (int u = 0; u<journeys.get(i).presSize(); u++) {
				serialJourneys+=journeys.get(i).getAtmPressure().get(u)+";";
			}
			serialJourneys+=">\n";
		}
		try {BufferedWriter out = new BufferedWriter(new FileWriter("journeys.txt"));
		out.write(serialJourneys+"End"); 
		out.close();
		}
		catch (Exception c) {System.out.println("JOURNEY LIST SAVING FAILED");}
	}
	public static void load() {
		if (new File("companyPW.txt").isFile()) {
			try {
				InputStream scl = new FileInputStream("companyPW.txt");
				BufferedReader buf = new BufferedReader(new InputStreamReader(scl));
				companyPassword  = buf.readLine();}
			catch (Exception c) {}
		}
		if (new File("clients.txt").isFile()) {
			try {
				InputStream scl = new FileInputStream("clients.txt");
				BufferedReader buf = new BufferedReader(new InputStreamReader(scl));
				String l = buf.readLine();
				while(!l.equals("End")) {
					int cID = 0;
					Client c = new Client();
					int u = 0;
					String s = "";
					for (int i =0; i<l.length(); i++) {
						if (l.charAt(i) == '|' | l.charAt(i) =='>') {
							if (u==5) {
								c.setPhone(s);
								clients.put(cID,c);
							}
							if (u==4) {c.setEmail(s);}
							if (u==3) {c.setAddress(s);}
							if (u==2) {c.setPassword(s);}
							if (u==1) {c.setName(s);}
							if (u==0) {cID = Integer.parseInt(s);}
							s = "";
							u++;
						} 
						else {
							s += l.charAt(i);
						}
					}
					l = buf.readLine();
				}
			}
			catch (Exception c) {System.out.println("CLIENT LIST LOADING FAILED\n"+c);}
			}
		if (new File("journeys.txt").isFile()) {
			try {
				InputStream scl = new FileInputStream("journeys.txt");
				BufferedReader buf = new BufferedReader(new InputStreamReader(scl));
				String l = buf.readLine();
				while(!l.equals("End")) {
					int jID=0;
					Journey j = new Journey();
					int u = 0;
					int y = 0;
					String s = "";
					for (int i =0; i<l.length(); i++) {
						if (l.charAt(i) == '|') {
							if (u==5) {j.setClientID(s);}
							if (u==4) {j.setContent(s);}
							if (u==3) {j.setStatus(s);}
							if (u==2) {j.setDestination(s);}
							if (u==1) {j.setOrigin(s);} 
							if (u==0) {jID = Integer.parseInt(s);}
							u++;
							s="";
						}
						if (l.charAt(i) == ';') {
							if (y==1) {
								j.tempAdd(Float.parseFloat(s));
							}
							if (y==2) {
								j.humAdd(Float.parseFloat(s));
							}
							if (y==3) {
								j.presAdd(Float.parseFloat(s));
							}
							s="";
						}
						if (l.charAt(i) == '>') {
							if (y==3) {
								journeys.put(jID, j);
							}
							s="";
							y++;
						}
						if (l.charAt(i) != '>' & l.charAt(i) != '|' & l.charAt(i) != ';') {
							s += l.charAt(i);
						}
					}
					l = buf.readLine();
				}
			}
			catch (Exception c) {System.out.println("JOURNEY LIST LOADING FAILED\n"+c);}
			}
		}
}