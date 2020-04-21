@tag
Feature: Registering a Journey

  @tag1
  Scenario: Successful registration
    Given port of origin "Copenhagen"
    And destination "New York"
    And content "Apples"
    And client "1978"
    When register journey
    Then display journey info
    
  @tag2
  Scenario: Searching for a clients journeys
  	Given port of origin "Copenhagen"
    And destination "New York"
    And content "Apples"
    And client "1978"
    When register journey
    Then display journey info
    When search for clients journeys
    Then display journey info
    
  @tag3
  Scenario: Saving journeys
  	Given port of origin "Copenhagen"
    And destination "New York"
    And content "Apples"
    And client "1978"
    When register journey
    Then display journey info
    When save journey info
  
	@tag4
	Scenario: Loading
    When load file
    Then display all journey info
   

