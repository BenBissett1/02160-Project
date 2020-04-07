package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class dataMap {
	
	Map <String, ArrayList<Integer>> dataMap = new HashMap<String, ArrayList<Integer>>();
	ArrayList<String> specificIDList = new ArrayList<String>();
	
	
}

public class tempDataMap extends dataMap {

	public boolean doesKeyExist (String specificID) {
		return specificIDList.contains(specificID);
	}
	
}
