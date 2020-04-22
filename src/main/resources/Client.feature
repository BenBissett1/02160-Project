@tag
Feature: Storing internal container status data to journey id

  @tag1
  Scenario: adding data
  	Given journey is "CHO"
  	And containerID is "123821"
  	When retrieve all data
  	And visual output
  	
  Scenario: removing data
    Given journey is "CHO"
  	And containerID is "123821"
  	When retrieve data "temp"
  	And display no data available invalid specificID 	
  	
  Scenario: adding data and false journey id
    Given journey is "CHO"
  	And containerID is "123821"
  	When retrieve data "temp"
  	And display no data available invalid specificID 

  Scenario: inserting data
    Given journey is "CHO"
  	And containerID is "123821"
  	When retrieve data "temp"
  	And display no data available invalid specificID 	