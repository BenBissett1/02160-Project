package test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map.Entry;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.request;
import main.Client;
import main.Container;
import main.Journey;
import main.dataStructure;
import main.Port;
import main.ResponseObject;

public class StepDefinition {
	
	Port port = new Port();
	Container container = new Container();
	Client client = new Client();
	dataStructure data = new dataStructure();
	Journey journey = new Journey();
	request request = new request();
	ResponseObject response;
//	//int newestJourneyAddition;
//	
////<<<<<<< HEAD

//	@Given("port of origin {string}")
//	public void port_of_origin(String location) {
//	    port.setLocationInitial(location);
//	}
//
//	@Given("destination {string}")
//	public void destination(String location) {
//	    port.setLocationFinal(location);
//	}
//
//	@Given("content {string}")
//	public void content(String content) {
//	    container.setContent(content);
//	}
//
//	@Given("company {string}")
//	public void company(String name) {
//		client.setName(name);
//	}
//	
//	@Given("^registration status is (true|false)$")
//	public void registration_status_is(boolean isRegistered) {
//		port.setRegistered(isRegistered);
//		container.setRegistered(isRegistered);
////		client.setRegistered(isRegistered); // OUTDATED
//	}
//
//	@When("register")
//	public void register() {
//		response = data.register(client, port, container);
//		
//	}
//
//	@Then("store data to CompanyID")
//	public void store_data_to_CompanyID() {
//		//TODO: STORE THE FUCKING DATA
////	    data.storeCompanyData(); // OUTDATED
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("store data to CustomerID")
//	public void store_data_to_CustomerID() {
////		data.storeCustomerData(); // OUTDATED
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("automaton displays message that registration was successful")
//	public void automaton_displays_message_that_registration_was_successful() {
//	    assertEquals(response.getErrorMessage(), "Registration successful");
//	}
//	
//	@Then("automaton displays message that already registered")
//	public void automaton_displays_message_that_already_registered() {
//	    assertEquals(response.getErrorMessage(), "Already registered");
//	}
//	
//	@Then("automaton displays message that registration was unsuccessful")
//	public void automaton_displays_message_that_registration_was_unsuccessful() {
//		assertEquals(response.getErrorMessage(), "Registration unsuccessful");
//	}
	
	
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
		request.removeData(data);
	}

	
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
		//String var = data.journeys.get(container.getJourneyID()).get(0).get(2);
		//System.out.println(var);
		assertEquals(response.getErrorMessage(), "Container enroute");
	}
	
	@Then("output container arrived at destination")
	public void output_container_arrived_at_destination() {
		//String var = data.journeys.get(container.getJourneyID()).get(0).get(2);
		//System.out.println(var);
		assertEquals(response.getErrorMessage(), "Container arrived");
	}
	
	@Then("output containerID not found in database")
	public void output_containerID_not_found_in_database() {
		/*for (Entry<Integer, List<List<String>>> entry : data.journeys.entrySet()) {
		System.out.println("Key: " + entry);
		System.out.println("Not found");
		}*/
		assertEquals(response.getErrorMessage(), "Container not found");
	}
	
	///////////////////////////////
	// End ////////////////////////
	// ContainerPosition.feature //
	///////////////////////////////
	
	
}





/*
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class StepDefinition {
	Container container = new Container();
	tempDataMap tempDataMap = new tempDataMap();
	responseObject response;
	
	@Given("containerID is {string}")
	public void containerid_is(String containerID) {
	    // Write code here that turns the phrase above into concrete actions
	    container.setContainerID(containerID);
	}
	@Given("journey is {string}")
	public void journey_is(String journey) {
	    // Write code here that turns the phrase above into concrete actions
	    container.setJourney(journey);
	}
	@Given("specificID is first time occurrence")
	public void specificid_is_first_time_occurrence() {
	    // Write code here that turns the phrase above into concrete actions
	    tempDataMap.doesKeyExist(container.specificID);
	}
	@Then("Input internal data and store in container")
	public void input_internal_data_and_store_in_container() {
	    // Write code here that turns the phrase above into concrete actions
	    container.setData();
	}
	@Then("transfer data from tempDataMap to dataMap")
	public void transfer_data_from_tempDataMap_to_dataMap() {
	    // Write code here that turns the phrase above into concrete actions
	    tempDataMap.dataMap.put(container.specificID + "," + "pressure",container.pressureList);
	    tempDataMap.dataMap.put(container.specificID + "," + "hum",container.humList);
	    tempDataMap.dataMap.put(container.specificID + "," + "temp",container.tempList);
	    
	    response = new responseObject(200, "data stored");
	}
	@Then("Display that data has been registered")
	public void display_that_data_has_been_registered() {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getErrorMessage(),"data stored");
	}	
	
	
	@When("retrieve all data")
	public void retrieve_all_data() {
	    // Write code here that turns the phrase above into concrete actions
	    container.getExpandedSpecificIDAll(container.specificID);
	    container.outPressure = tempDataMap.dataMap.get(container.holdID1);
	    container.outHum = tempDataMap.dataMap.get(container.holdID2);
	    container.outTemp = tempDataMap.dataMap.get(container.holdID3);
	}
	@When("retrieve data {string}")
	public void retrieve_data(String dataType) {
	    // Write code here that turns the phrase above into concrete actions
	    container.random = tempDataMap.dataMap.get(container.createExpandedSpecificID(dataType));
	    
	    response = new responseObject(210, "single dataType stored");
	}
	
	@When("visual output")
	public void visual_output() {
	    // Write code here that turns the phrase above into concrete actions
//		response.getErrorMessage().equals("single dataType stored");
		throw new io.cucumber.java.PendingException();
	}
	@When("display no data available for specificID")
	public void display_no_data_available_for_specificID() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("display no data available invalid specificID")
	public void display_no_data_available_invalid_specificID() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
}*/