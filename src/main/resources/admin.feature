@tag
Feature: Storing internal container status data to journey id

  @tag1
  Scenario: adding to already existing data 
    Given journey id is 12234 and data is 1 2 3
    And internal status parameter is "humidity"
    And list is not empty
    And data to add is "[1,2,3]"
  	
  Scenario: removing data
  Given journey id is 12234
  And journey id does exist
  And internal status parameter is "humidity"
  And list is not empty
  And remove data 1
    
  	
  Scenario: adding data and false journey id
   

  Scenario: inserting data
    