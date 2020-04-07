#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Retrieve data to client

  @tag1
  Scenario: retrieve all data by specificID
  	Given journey is "CHO"
  	And containerID is "123821"
  	When retrieve all data
  	And visual output
  	
  Scenario: retrieve data by specificID missing data
  	Given journey is "CHO"
  	And containerID is "123821"
  	When retrieve data "pressure"
  	And display no data available for specificID
  	
  Scenario: retrieve data by invalid specificID
    Given journey is "CHO"
  	And containerID is "123821"
  	When retrieve data "temp"
  	And display no data available invalid specificID
