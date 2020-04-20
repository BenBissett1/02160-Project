@tag
Feature: Registering a Journey

  @tag1
  Scenario: Successful registration
    Given port of origin "Copenhagen"
    And destination "New York"
    And content "Apples"
    And client "Fruits Co."
    And registration status is false
    When register
    Then store data to journey
    And store data to client
    And automaton displays message that registration was successful
    
  @tag2
  Scenario: Already registered
    Given port of origin "Copenhagen"
    And destination "New York"
    And content "Apples"
    And client "Fruits Co."
    And registration status is true
    When register
    Then automaton displays message that already registered
    
  @tag3
  Scenario: Unsuccessful registration
    Given port of origin ""
    And destination ""
    And content ""
    And client ""
    And registration status is false
    When register
    Then automaton displays message that registration was unsuccessful


