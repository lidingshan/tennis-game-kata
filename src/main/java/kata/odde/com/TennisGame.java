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
        if (firstPlayerPoints > 3
                && firstPlayerPoints - secondPlayerPoints == 1) {
            this.score = "Advantage : 40";
        } else {
            String firstPlayerScore = scoreMap.get(firstPlayerPoints);
            String secondPlayerScore = scoreMap.get(secondPlayerPoints);

            this.score = firstPlayerScore + " : " + secondPlayerScore;

            if (firstPlayerPoints == secondPlayerPoints
                    && firstPlayerPoints == 3) {
                this.score = "Deuce";
            }
        }

        return score;
    }

    public void firstPlayerGetAPoint() {
        firstPlayerPoints++;
    }

    public void secondPlayerGetAPoint() {
        secondPlayerPoints++;
    }
}
