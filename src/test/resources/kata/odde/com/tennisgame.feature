Feature: Tennis Game

   Background:
    Given start a new game with the name "ATO Game 1"
    And two players Tom and Jerry in the game


   Scenario: New Game
    Then the game name should be "ATO Game 1"
    And the game should have two players "Tom" an "Jerry"
    And both of them should have score 0

   Scenario: Tom win the first point
    When Tom get 1 point(s)
    Then Tom score is 15

   Scenario: Tom win the second point
    When Tom get 2 point(s)
    Then Tom score is 30