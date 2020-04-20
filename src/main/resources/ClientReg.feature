@tag
Feature: Registering a client

  @tag1
  Scenario: Successful registration
    Given name is "John&co"
    And password is "Snow123"
    And address is "275 Brookmere rd"
    And email is "John89@johnco.com"
    And phone is "123456"
    When register clientN
    Then display client info
 

  @tag2
  Scenario: Already registered
    Given name is "John&co"
    And password is "Snow123"
    And address is "275 Brookmere rd"
    And email is "John89@johnco.com"
    And phone is "123456"
    When register clientN
    Then message already registered 
 
 @tag3
 Scenario: Succesful saving
   Given name is "John&co"
   And password is "Snow123"
   And address is "275 Brookmere rd"
   And email is "John89@johnco.com"
   And phone is "123456"
   When register clientN
   Then display client info
   When user closes program
	 Then message files saved

  