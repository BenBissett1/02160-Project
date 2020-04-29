@tag
Feature: Registering a client

  @tag1
  Scenario: Successful registration
    Given name is "John&co"
    And password is "Snow123"
    And address is "275 Brookmere rd"
    And email is "John89@johnco.com"
    And phone is "123456"
    When register client
    Then display client info
    Then check client

  @tag2
  Scenario: Already registered
    Given name is "John&co"
    And password is "Snow123"
    And address is "275 Brookmere rd"
    And email is "John89@johnco.com"
    And phone is "123456"
    When register client
    Then message already registered 
 
 @tag3
 Scenario: Saving & Search by name
   Given name is "John&co2"
   And password is "Snow123"
   And address is "276 Brookmere rd"
   And email is "John88@johnco.com"
   And phone is "123466"
   When register client
   Then display client info
   And save client info
	 Given name is "John&co2"
	 When search by name
	 Then display client info
	 
	@tag4
	Scenario: Loading
    When load clients
    Then display all client info
    
  @tag5
  Scenario: updating client info
  	When load clients
  	Given name is "John&co2"
  	When search by name
  	Given password is "Snow123"
  	And address is "277 Brookmere rd"
  	And email is "John88@johnco.com"
  	And phone is "123467"
  	Then update client
  	
  