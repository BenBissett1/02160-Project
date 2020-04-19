package main;


public class Database {
	
	boolean isCompleteDataSet;
	Container container2 = new Container();
	
	public ResponseObject register(Client client, Port port, Container container) {
		ResponseObject response;
		if (!client.isRegistered()) {
			
			if (port.getLocationInitial().equals("")
					|| port.getLocationFinal().equals("")
					|| container.getContent().equals("")) {
				response = new ResponseObject(220, "Registration unsuccessful");
			} else {
				client.setRegistered(true);
				response = new ResponseObject(200, "Registration successful");
			}
		} else {
			response = new ResponseObject(210, "Already registered");
		}
		return response;
	}

	public void storeCompanyData() {
		//TODO: This
		
	}
	public void storeCustomerData() {
		//TODO: This
		
	}

	public boolean isCompleteDataSet() {
		return isCompleteDataSet;
	}

	public void setCompleteDataSet(boolean isCompleteDataSet) {
		this.isCompleteDataSet = isCompleteDataSet;
	}

	

	

}
