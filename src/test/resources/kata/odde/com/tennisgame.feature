Feature: Tennis Game



   Scenario: Start a new game
    Given start a new game with the name "ATO Game 1"
    Then the game name should be "ATO Game 1"

   Scenario: Add players
    Given two players Tom and Jerry in the game
    Then the game should have two players "Tom" an "Jerry"
    And both of them should have score 0

   Scenario: Tom get the first point
    Given Tom and Jerry start the name
    When Tom get one point
    Then Tom score is 15