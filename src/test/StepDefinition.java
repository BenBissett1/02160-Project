package test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import main.Client;
import main.Journey;
import main.dataStructure;
import main.request;

public class StepDefinition {
	
	Client client = new Client();
	dataStructure data = new dataStructure();
	Journey journey = new Journey();
	request request = new request();
	
	///////////////////////
	// Start //////////////
	// ClientReg.feature //
	///////////////////////
	
	
	@Given("name is {string}")
	public void setName(String n) {
		client.setName(n);
	}
	@Given("password is {string}")
	public void setPassword(String n) {
		client.setPassword(n);
	}
	@Given("address is {string}")
	public void setAddress(String n) {
		client.setAddress(n);
	}
	@Given("email is {string}")
	public void setEmail(String n) {
		client.setEmail(n);
	}
	@Given("phone is {string}")
	public void phone_is(String string) {
		client.setPhone(string);
	}
	@When("register client") 
	public void regClient() {
		client.setID(Client.regNewClient(client.getName(), client.getPassword(), client.getAddress(), client.getEmail(), client.getPhone()));
	}
	@Then("display client info")
	public void displayInfo() {
		System.out.println(client.getID());
	}
	@Then("save client info")
	public void saveCInfo() {
		dataStructure.save();
	}
	@When("load clients")
	public void loadCInfo() {
		dataStructure.load();
	}
	@Then("display all client info")
	public void displayAllInfo() {
		System.out.println(dataStructure.allClients());
	}
	@Then("message already registered")
	public void message_already_registered() {
		if (client.getID() == -1) {
			System.out.println("already registered");
		};
	}
	@When("load journeys")
	public void loadclients() {
		dataStructure.load();
	}
	@When("search by name") 
	public void searchName() {
		client.setID(Client.searchC(client.getName(), 0));
	}
	@Then("update client")
	public void update() {
		Client.updateClient(client.getID(), client.getName(), client.getPassword(), client.getAddress(), client.getEmail(), client.getPhone());
	}
	@Then("check client")
	public void clientcheck() {
		System.out.println(Client.clientExists(client.getID()));

	}
	
	
	///////////////////////
	// End ////////////////
	// ClientReg.feature //
	///////////////////////
	
	
	
	/////////////////////////////////
	// Start ////////////////////////
	// JourneyRegistration.feature //
	/////////////////////////////////
	
	

	@Given("port of origin {string}")
	public void port_of_origin(String location) {
		journey.setOrigin(location);
	}
	
	@Given("destination {string}")
	public void destination(String location) {
		journey.setDestination(location);
	}
	
	@Given("content {string}")
	public void content(String content) {
		journey.setContent(content);
	}
	
	@Given("client {string}")
	public void client(String name) {
		journey.setClientID(name);
	}
	@Given("status {string}")
	public void status(String x) {
		journey.setStatus(x);
	}
	

	@When("register journey")
	public void register() {
		int i = Journey.regNewJourney(journey.getOrigin(),journey.getDestination(),journey.getContent(),Integer.parseInt(journey.getClientID()));
		journey.setStatus(dataStructure.journeys.get(i).getStatus());
		journey.setJID(i);
//		journey.setStatus(dataStructure.journeys.get(journey.getJID()).getStatus());
	}

	@Then("display journey info")
	public void displayJinfo() {
		System.out.println(journey.getJID());

	}
	@Then("search by origin")
	public void origin() {
		System.out.println(Journey.searchJ(journey.getOrigin(), 0, Integer.parseInt(journey.getClientID())));
	}
	@Then("search by destination")
	public void destination() {
		System.out.println(Journey.searchJ(journey.getDestination(), 1, Integer.parseInt(journey.getClientID())));
	}
	@Then("search by status")
	public void status() {
		System.out.println(Journey.searchJ(journey.getStatus(), 2, Integer.parseInt(journey.getClientID())));
	}
	@Then("search by content")
	public void content() {
		System.out.println(Journey.searchJ(journey.getContent(), 3, Integer.parseInt(journey.getClientID())));
	}
	@Then("display all journey info")
	public void displayAllJinfo() {
		System.out.println(dataStructure.allJourneys());

	}
	@Then("check journey")
	public void journeycheck() {
		System.out.println(Journey.journeyExists(journey.getJID()));

	}
	@When("search for clients journeys")
	public void search_for_clients_journeys() {
		System.out.println(Journey.searchJ(""+journey.getClientID(), 4, Integer.parseInt(journey.getClientID())));
	}
	@When("save journey info")
	public void saveJ() {
		dataStructure.save();
	}
	@Then("update journey")
	public void updateJ() {
		Journey.updateJourney(journey.getJID(), journey.getDestination(), journey.getStatus());
	}
	@Given("client")
	public void setClientinJ() {
		journey.setClientID(""+client.getID());;
	}
	
	
	
	
	/////////////////////////////////
	// End //////////////////////////
	// JourneyRegistration.feature //
	/////////////////////////////////
	
	
	// Start
	// admin.feature
	
	@Given("journey id is {int}")
	public void journey_id_is(Integer journeyID) {
	    request.setJourneyID(journeyID);
	}
	
	@Given("internal status parameter is {string}")
	public void internal_status_parameter_is(String thisData) {
		request.setThisData(thisData);
	}
	
	@Given("journey id does exist")
	public void journey_id_does_exist() {
		request.doesJourneyExist();
	}
	
	@Given("remove data {int}")
	public void remove_data(Integer data) {
		
	}

	
	//////////////////
	// Start ///////////
	// Client.feature //
	////////////////////
	
	@Given("retrieve data")
	public void retrieve_data() {
//		request.getData();
	}
	
	////////////////////
	// End /////////////
	// Client.feature //
	////////////////////
	
}