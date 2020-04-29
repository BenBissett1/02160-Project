@tag
Feature: Registering a Journey

  @tag1
  Scenario: Successful registration
    Given name is "John&co"
    And password is "Snow123"
    And address is "27 Brookmere rd"
    And email is "John8@johnco.com"
    And phone is "123466"
    When register client
    Then display client info
    Given port of origin "Copenhagen"
    And destination "New York"
    And content "Apples"
    And client
    When register journey
    Then display journey info
    Then check journey

    
  @tag2
  Scenario: Searching for a clients journeys
  	Given name is "John&co2"
    And password is "Snow123"
    And address is "276 Brookmere rd"
    And email is "John88@johnco.com"
    And phone is "1234626"
    When register client
    Then display client info
    Given port of origin "Copenhagen"
    And destination "New York"
    And content "Apples"
    And client
    When register journey
    Then display journey info
    When search for clients journeys
    Then display journey info
    
  @tag3
  Scenario: Saving journeys
  	Given name is "John&co24"
    And password is "Snow123"
    And address is "2764 Brookmere rd"
    And email is "John848@johnco.com"
    And phone is "12343266"
    When register client
    Then display client info
    Given port of origin "Copenhagen"
    And destination "New York"
    And content "Apples"
    And client
    When register journey
    Then display journey info
    When save journey info
    
  
	@tag4
	Scenario: Loading
    When load journeys
    Then display all journey info
  
  @tag5
  Scenario: updating journey info
  	Given name is "John&co23"
    And password is "Snow123"
    And address is "2726 Brookmere rd"
    And email is "John858@johnco.com"
    And phone is "12346126"
    When register client
    Then display client info
    Given port of origin "Copenhagen"
    And destination "New York"
    And content "Apples"
    And client
    When register journey
  	Then display journey info
  	Given destination "New York"
  	Then update journey
  	
  @tag6
  Scenario: Searching
  	Given name is "John&co23"
    And password is "Snow123"
    And address is "2726 Brookmere rd"
    And email is "John858@johnco.com"
    And phone is "12346126"
    When register client
    Then display client info
    Given port of origin "Copenhagen"
    And destination "New York"
    And content "Apples"
    And client
    When register journey
  	Then display journey info
  	Then search by origin
  	Then search by destination
  	Then search by status
  	Then search by content

