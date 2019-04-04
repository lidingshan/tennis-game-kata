Feature: Tennis game kata

    Scenario: start a new game
        Given a new game
        Then the score should be "Love : Love"

    Scenario Outline: first player won points
        When first player got <number> of points
        Then the score should be "<expected>"

        Examples:
            | number    | expected     |
            | 1         | 15 : Love    |
            | 2         | 30 : Love    |



