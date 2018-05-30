Feature: Characters CRUD operations.

  Scenario: Adding new character
    Given I created new character
    When I add created character to character list
    Then Created character appears in characters list

  Scenario: Selecting existing character
    Given I have character from list that exists in system
    When I select character from the list by id
    Then Existing character is returned

  Scenario: Updating existing character
    Given I have character from list that exists in system
    When I update character with new values
    Then Character is updated in characters list

  Scenario: Deleting existing character
    Given I have character from list that exists in system
    When I delete character
    Then Character is not present in characters list