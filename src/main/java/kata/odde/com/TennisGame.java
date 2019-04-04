package kata.odde.com;

public class TennisGame {
    private String score;
    private int firstPlayerPoints = 0;

    public String getScore() {
        if (firstPlayerPoints == 1) {
            score = "15 : Love";
        } else if (firstPlayerPoints == 2) {
            score = "30 : Love";
        }
        else {
            score = "Love : Love";
        }
        return score;
    }

    public void firstPlayerGetAPoint() {
        firstPlayerPoints++;
    }
}
