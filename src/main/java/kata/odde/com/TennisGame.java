package kata.odde.com;

import java.util.HashMap;

public class TennisGame {
    private String score;
    private int firstPlayerPoints = 0;

    private final HashMap<Integer, String> scoreMap = new HashMap<Integer, String>();
    private int secondPlayerPoints = 0;

    public TennisGame() {
        scoreMap.put(0, "Love");
        scoreMap.put(1, "15");
        scoreMap.put(2, "30");
        scoreMap.put(3, "40");
    }

    public String getScore() {
        if (isAdvantage()) {
            this.score = firstPlayerPoints > secondPlayerPoints
                    ? "Advantage : 40" : "40 : Advantage";
        }
        else if (isDeuce()) {
            this.score = "Deuce";
        }
        else {
            String firstPlayerScore = scoreMap.get(firstPlayerPoints);
            String secondPlayerScore = scoreMap.get(secondPlayerPoints);

            this.score = firstPlayerScore + " : " + secondPlayerScore;

        }

        return score;
    }

    private boolean isDeuce() {
        return firstPlayerPoints == secondPlayerPoints
                && firstPlayerPoints == 3;
    }

    private boolean isAdvantage() {

        return Math.abs(firstPlayerPoints - secondPlayerPoints) == 1
                && (firstPlayerPoints > 3 || secondPlayerPoints > 3);
    }

    public void firstPlayerGetAPoint() {
        firstPlayerPoints++;
    }

    public void secondPlayerGetAPoint() {
        secondPlayerPoints++;
    }
}
