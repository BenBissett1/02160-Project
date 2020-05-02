@tag
Feature: client retrieve data

  @tag1
  Scenario: retrieve data humidity
    Given journey id is 12234
    And journey id does exist
    And internal status parameter is "humidity"
    When list is not empty
    Then retrieve data
 
  Scenario: retrieve data temperature
   Given journey id is 12234
    And journey id does exist
    And internal status parameter is "temperature"
    When list is not empty
    Then retrieve data
   
  Scenario: retrieve data pressure
   Given journey id is 12234
    And journey id does exist
    And internal status parameter is "pressure"
    When list is not empty
    Then retrieve data
#    
#   Scenario: retrieve data
#   Given journey id is 12234
#    And journey id does exist
#    And internal status parameter is "random"
#    And list is not empty
#    And retrieve data

  Scenario: retrieve last data temperature
   Given journey id is 12234
    And journey id does exist
    And internal status parameter is "temperature"
    When list is not empty
    Then retrieve last data
    
  Scenario: retrieve last data humidty
   Given journey id is 12234
    And journey id does exist
    And internal status parameter is "humidity"
    When list is not empty
    Then retrieve last data
    
  Scenario: retrieve last data pressure
   Given journey id is 12234
    And journey id does exist
    And internal status parameter is "pressure"
    When list is not empty
    Then retrieve last data