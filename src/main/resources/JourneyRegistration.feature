@tag
Feature: Registering a Journey

  @tag1
  Scenario: Successful registration
    Given port of origin "Copenhagen"
    And destination "New York"
    And content "Apples"
    And client "1753"
    When register journey
    Then display journey info
    And check journey
    
  @tag2
  Scenario: Searching for a clients journeys
    Given port of origin "Copenhagen"
    And destination "New York"
    And content "Apples"
    And client "1753"
    When search for clients journeys
    Then display journey info
    
  @tag3
  Scenario: Saving journeys with container information
    Given port of origin "Copenhagen"
    And destination "New York"
    And content "Apples"
    And client "1753"
    When register journey
    Then display journey info
    And  save journey info
    
	@tag4
	Scenario: Loading
    When load journeys
    Then display all journey info
  
  @tag5
  Scenario: updating journey info
    Given port of origin "Copenhagen"
    And destination "New York"
    And content "Apples"
    And client "1753"
    When register journey
  	Then display journey info
  	Then update journey
  	
  @tag6
  Scenario: Searching
    Given port of origin "Copenhagen"
    And destination "New York"
    And content "Apples"
    And client "1753"
    When register journey
  	Then display journey info
  	And search by origin
  	And search by destination
  	And search by status
  	And search by content

