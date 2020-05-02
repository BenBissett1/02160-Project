@tag
Feature: Manipulating container statuses

  @tag1
  Scenario: updating container status
    Given journey id is 12234
    And journey id does exist
    And a temperature 1.0
    And a humidity 1.0
    And a pressure 1.0
    When list is not empty
    Then add current values