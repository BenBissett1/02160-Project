@tag
Feature: Company password manipulation

  @tag1
  Scenario: matching company password
    Given a password "0000"
    Then check equals current password
    
  @tag2
  Scenario: changing company password
    Given a password "0000"
    And company password match is true
    And a new password "1234"
    Then change password