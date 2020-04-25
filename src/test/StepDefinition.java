package test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map.Entry;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import main.Client;
import main.Container;
import main.Journey;
import main.dataStructure;
import main.Port;
import main.ResponseObject;
import main.request;

public class StepDefinition {
	
	Port port = new Port();
	Container container = new Container();
	Client client = new Client();
	dataStructure data = new dataStructure();
	Journey journey = new Journey();
	request request = new request();
	ResponseObject response;
	
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
		client.setID(dataStructure.regNewClient(client.getName(), client.getPassword(), client.getAddress(), client.getEmail(), client.getPhone()));
	}
	@Then("display client info")
	public void displayInfo() {
		System.out.println(dataStructure.clients.get(client.getID()));
	}
	@Then("display all client info")
	public void displayAllInfo() {
		System.out.println(dataStructure.clients);
	}
	@Then("message already registered")
	public void message_already_registered() {
		if (client.getID() == -1) {
			System.out.println("already registered");
		};
	}
	@When("user closes program")
	public void user_closes_program() {
	    dataStructure.save();
	}

	@Then("message files saved")
	public void message_files_saved() {
	    System.out.println("Saved file");;
	}
	@When("load file")
	public void loadclients() {
		dataStructure.load();

	
	}
	@When("search by name") 
	public void searchName() {
		client.setID(dataStructure.searchC(client.getName(), 0));
	}
	@Then("update client")
	public void update() {
		dataStructure.updateClient(client.getID(), client.getName(), client.getPassword(), client.getAddress(), client.getEmail(), client.getPhone());
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
		journey.setJID(dataStructure.regNewJourney(journey.getOrigin(),journey.getDestination(),journey.getContent(),Integer.parseInt(journey.getClientID())));
	}

	@Then("display journey info")
	public void displayJinfo() {
		System.out.println(dataStructure.journeys.get(journey.getJID()));

	}
	@Then("display all journey info")
	public void displayAllJinfo() {
		System.out.println(dataStructure.journeys);

	}
	@When("search for clients journeys")
	public void search_for_clients_journeys() {
		System.out.println(dataStructure.searchJ(""+journey.getClientID(), 4, Integer.parseInt(journey.getClientID())));
	}
	@When("save journey info")
	public void saveJ() {
		data.save();
	}
	@Then("update journey")
	public void updateJ() {
		dataStructure.updateJourney(journey.getJID(), journey.getOrigin(), journey.getDestination(), journey.getStatus(),journey.getContent(), journey.getClientID());
	}
	
	
	
	
	/////////////////////////////////
	// End //////////////////////////
	// JourneyRegistration.feature //
	/////////////////////////////////
	
	
	///////////////////////////////
	// Start //////////////////////
	// ContainerPosition.feature //
	///////////////////////////////
	
	@Given("a containerid {int}")
	public void a_containerid(Integer int1) {
		container.setJourneyID(int1);
	}
	
	@Given("^containeridInvalid is (true|false)$")
	public void containeridinvalid_is_false(boolean validContainerID) {
		container.setValidContainerID(validContainerID);
	}
	
	@Given("^enroute status is (true|false)$")
	public void enroute_status_is_true(boolean isEnroute) {
		container.setEnroute(isEnroute);
	}
	
	@When("retrieving")
	public void retrieving() {
		response = dataStructure.position(container);
	}
	
	@Then("output coordinates of container")
	public void output_coordinates_of_container() {
		assertEquals(response.getErrorMessage(), "Container enroute");
	}
	
	@Then("output container arrived at destination")
	public void output_container_arrived_at_destination() {
		assertEquals(response.getErrorMessage(), "Container arrived");
	}
	
	@Then("output containerID not found in database")
	public void output_containerID_not_found_in_database() {
		assertEquals(response.getErrorMessage(), "Container not found");
	}
	
	///////////////////////////////
	// End ////////////////////////
	// ContainerPosition.feature //
	///////////////////////////////
	
	
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
	
	@Given("list is not empty")
	public void list_is_not_empty() {
		request.listNotEmpty();
	}

	@Given("data to add is {string}")
	public void data_to_add_is(List<String> data) {
		request.addData(data);
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
		request.getData();
	}
	
	////////////////////
	// End /////////////
	// Client.feature //
	////////////////////
	
}