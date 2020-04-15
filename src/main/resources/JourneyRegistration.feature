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
Feature: Registering a Journey

  @tag1
  Scenario: Successful registration
    Given port of origin "Copenhagen"
    And destination "New York"
    And content "dildos"
    And company "Freddie's Dildos Inc."
    When finished registration
    Then store data to CompanyID
    And store data to CustomerID
    And display registration successful
    
  @tag2
  Scenario: Unsuccessful registration, invalid port of origin
    Given port of origin ""
    And destination "New York"
    And content "dildos"
    And company "Freddie's Dildos Inc."
    When finished registration
    Then display registration unsuccessful, invalid port of origin
   
  @tag3
  Scenario: Unsuccessful registration, invalid destination
    Given port of origin "Copenhagen"
    And destination ""
    And content "dildos"
    And company "Freddie's Dildos Inc."
    When finished registration
    Then display registration unsuccessful, invalid destination

  @tag4
  Scenario: Unsuccessful registration, invalid content
    Given port of origin "Copenhagen"
    And destination "New York"
    And content ""
    And company "Freddie's Dildos Inc."
    When finished registration
    Then display registration unsuccessful, invalid content
    
  @tag5
  Scenario: Unsuccessful registration, invalid company
    Given port of origin "Copenhagen"
    And destination "New York"
    And content "dildos"
    And company ""
    When finished registration
    Then display registration unsuccessful, invalid company 
    
  @tag6
  Scenario: Unsuccessful registration, invalid journey
    Given port of origin "Copenhagen"
    And destination "Copenhagen"
    And content "dildos"
    And company "Freddie's Dildo Inc."
    When finished registration
    Then display registration unsuccessful, invalid journey
    
  @tag7
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
