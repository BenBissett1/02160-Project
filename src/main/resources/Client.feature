#@tag
#Feature: Retrieve data to client
#
#  @tag1
#  Scenario: retrieve all data by specificID
#  	Given journey is "CHO"
#  	And containerID is "123821"
#  	When retrieve all data
#  	And visual output
#  	
#  Scenario: retrieve data by specificID missing data
#  	Given journey is "CHO"
#  	And containerID is "123821"
#  	When retrieve data "pressure"
#  	And display no data available for specificID
#  	
#  Scenario: retrieve data by invalid specificID
#    Given journey is "CHO"
#  	And containerID is "123821"
#  	When retrieve data "temp"
#  	And display no data available invalid specificID

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