#@tag
#Feature: Retrieving container position
#
#  @tag1
#  Scenario: Container enroute
#    Given a containerid 5000
#    And containeridInvalid is false
#    And enroute status is true
#    When retrieving
#    Then output coordinates of container
#    
#  @tag1
#  Scenario: Container arrived
#    Given a containerid 5000
#    And containeridInvalid is false
#    And enroute status is false
#    When retrieving
#    Then output container arrived at destination
#    
#  @tag1
#  Scenario: No container found
#    Given a containerid 1
#    And containeridInvalid is true
#    When retrieving
#    Then output containerID not found in database