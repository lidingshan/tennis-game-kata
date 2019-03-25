Feature: Tennis Game

   Background:
    Given start a new game with the name "ATO Game 1"
    And two players Tom and Jerry in the game


   Scenario: New Game
    Then the game name should be "ATO Game 1"
    And the game should have two players "Tom" an "Jerry"
    And Tom score should be 0
    And Jerry score should be 0

   Scenario: Tom win the first point
    When Tom get 1 point(s)
    Then Tom score should be 15

   Scenario: Tom win the second point
    When Tom get 2 point(s)
    Then Tom score should be 30

   Scenario: Tom win the third point
    When Tom get 3 point(s)
    Then Tom score should be 40

   Scenario: Tom win the game
    When Tom get 4 point(s)
    Then the winner should be Tom

   Scenario: Jerry win the game
    When Jerry get 4 point(s)
    And Tom get 2 point(s)
    Then the winner should be Jerry

   Scenario: Winner must win 2 points at least
    When Jerry get 4 point(s)
    And Tom get 3 point(s)
    Then the winner should be unknown

   Scenario: Two players both have won 4 points
    When Jerry get 4 point(s)
    And Tom get 4 point(s)
    Then Jerry score should be Deuce
    And Tom score should be Deuce

   Scenario: The winner must have gotten 3 points before win
    When Tom get 3 point(s)
    And Jerry get 0 point(s)
    Then the winner should be unknown
