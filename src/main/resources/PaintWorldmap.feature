@tag
Feature: Painting the worldmap

  @tag1
  Scenario: painting world map for company
    Given a background worldmap image
    And a number 0
    Then paint the company map
    
  @tag1
  Scenario: painting world map for client
    Given a background worldmap image
    And a client id value 1
    Then paint the client map