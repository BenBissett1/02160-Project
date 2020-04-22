@tag
Feature: Storing internal container status data to journey id

  @tag1
  Scenario: adding to already existing data 
    Given journey id is 12234
    And journey id does exist is true
    And internal status parameter is "humidity"
    And list is not empty
    And data to add is "[1,2,3]"
  	
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