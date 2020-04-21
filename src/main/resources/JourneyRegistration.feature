@tag
Feature: Registering a Journey

  @tag1
  Scenario: Successful registration
    Given port of origin "Copenhagen"
    And destination "New York"
    And content "Apples"
<<<<<<< HEAD
    And client "1978"
    When register journey
    Then display journey info
=======
    And client "Fruits Co."
    And registration status is false
    When register
    Then store data to journey
    And store data to client
    And automaton displays message that registration was successful
>>>>>>> branch 'master' of https://github.com/BenBissett1/02160-Project
    
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
   

