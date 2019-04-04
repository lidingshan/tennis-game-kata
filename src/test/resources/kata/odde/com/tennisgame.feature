Feature: Tennis game kata

    Scenario: start a new game
        Given a new game
        Then the score should be "Love : Love"

    Scenario Outline: first player won points
        When first player got <number> of points
        Then the score should be "<expected>"

        Examples:
            |   number    | expected     |
            |   1         | 15 : Love    |
            |   2         | 30 : Love    |
            |   3         | 40 : Love    |


    Scenario Outline: second player won points
        When second player got <number> of points
        Then the score should be "<expected>"

        Examples:
            |   number    | expected    |
            |   0         | Love : Love |
            |   1         | Love : 15   |
            |   2         | Love : 30   |
            |   3         | Love : 40   |

    Scenario Outline: both players won points
        When first player got <X> of points
        When second player got <Y> of points
        Then the score should be "<expected>"

        Examples:
            |   X   |   Y   |   expected    |
            |   1   |   1   |   15 : 15     |
            |   3   |   3   |   Deuce       |

