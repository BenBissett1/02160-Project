@tag
Feature: client retrieve data

  @tag1
  Scenario: retrieve data
   Given journey id is 12234
    And journey id does exist
    And internal status parameter is "humidity"
    And list is not empty
    And retrieve data
 
  Scenario: retrieve data
   Given journey id is 12234
    And journey id does exist
    And internal status parameter is "temperature"
    And list is not empty
    And retrieve data
   
  Scenario: retrieve data
   Given journey id is 12234
    And journey id does exist
    And internal status parameter is "pressure"
    And list is not empty
    And retrieve data
    
   Scenario: retrieve data
   Given journey id is 12234
    And journey id does exist
    And internal status parameter is "random"
    And list is not empty
    And retrieve data