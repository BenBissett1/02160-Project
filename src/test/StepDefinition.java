package test;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import main.Client;
import main.Container;
import main.Database;
import main.Port;
import main.ResponseObject;

public class StepDefinition {
	
	/////////////////////////////////
	// Start ////////////////////////
	// JourneyRegistration.feature //
	/////////////////////////////////
	
	Port port = new Port();
    Container container = new Container();
	Client client = new Client();
	Database data = new Database();
	ResponseObject response;
	
	@Given("port of origin {string}")
	public void port_of_origin(String location) {
	    port.setLocationInitial(location);
	}

	@Given("destination {string}")
	public void destination(String location) {
	    port.setLocationFinal(location);
	}

	@Given("content {string}")
	public void content(String content) {
	    container.setContent(content);
	}

	@Given("company {string}")
	public void company(String name) {
		client.setName(name);
	}
	
	@Given("^registration status is (true|false)$")
	public void registration_status_is(boolean isRegistered) {
		port.setRegistered(isRegistered);
		container.setRegistered(isRegistered);
		client.setRegistered(isRegistered);
	}

	@When("register")
	public void register() {
		response = data.register(client, port, container);
		
	}

	@Then("store data to CompanyID")
	public void store_data_to_CompanyID() {
		//TODO: STORE THE FUCKING DATA
	    data.storeCompanyData();
	}

	@Then("store data to CustomerID")
	public void store_data_to_CustomerID() {
		data.storeCustomerData();
	}

	@Then("automaton displays message that registration was successful")
	public void automaton_displays_message_that_registration_was_successful() {
	    assertEquals(response.getErrorMessage(), "Registration successful");
	}
	
	@Then("automaton displays message that already registered")
	public void automaton_displays_message_that_already_registered() {
	    assertEquals(response.getErrorMessage(), "Already registered");
	}
	
	@Then("automaton displays message that registration was unsuccessful")
	public void automaton_displays_message_that_registration_was_unsuccessful() {
		assertEquals(response.getErrorMessage(), "Registration unsuccessful");
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
	    container.setIdentity(int1);
	}

	@Given("^containeridInvalid is (true|false)$")
	public void containeridinvalid_is_false(boolean validContainerID) {
	    container.setValidContainerID(validContainerID);
	}

	@Given("^enroute status is (true|false)$")
	public void enroute_status_is_true(boolean isEnroute) {
		container.isEnroute(isEnroute);
	}

	@When("retrieving")
	public void retrieving() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("output coordinates of container")
	public void output_coordinates_of_container() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("output container arrived at destination")
	public void output_container_arrived_at_destination() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("output containerID not found in database")
	public void output_containerID_not_found_in_database() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	
	///////////////////////////////
	// End ////////////////////////
	// ContainerPosition.feature //
	///////////////////////////////
	
	
	
	
	
	////////////////////
	// Start ///////////
	// Client.feature //
	////////////////////
	
	//DOES A JOURNEY HAVE ITS OWN ID AS WELL AS A CONTAINER HAVE ITS OWN ID?
	
	/*
	@Given("journey is {string}")
	public void journey_is(String journey) {
		port.setJourney(journey);
	}

	@Given("containerID is {string}")
	public void containerid_is(int identity) {
	    container.setIdentity(identity);
	}
	
	@Given("^complete data set is (true|false)$")
	public void complete_data_set_is(boolean isCompleteDataSet) {
	    data.setCompleteDataSet(isCompleteDataSet);
	}

	@When("retrieve data")
	public void retrieve_data() {
	    //TODO: response or getContainerID directly?
	}

	@Then("visual output")
	public void visual_output() {
	    //TODO: Visual output
	}
	
	@Then("display no data available invalid specificID")
	public void display_no_data_available_invalid_specificID() {
		assertEquals(response.getErrorMessage(), "Invalid container ID");
	}
	*/
	
	
	////////////////////
	// End /////////////
	// Client.feature //
	////////////////////
	
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