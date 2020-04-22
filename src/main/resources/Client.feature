@tag
Feature: client retrieve data

  @tag1
  Scenario: retrieve data
   Given journey id is 12234
    And journey id does exist is true
    And internal status parameter is "humidity"
    And list is not empty
    And retrieve data