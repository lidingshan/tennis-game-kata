package kata.odde.com;

public class TennisGame {
    private String score;
    private int firstPlayerPoints = 0;

    public String getScore() {
        String firstPlayerScore = "Love";
        if (firstPlayerPoints == 1) {
            firstPlayerScore = "15";
        } else if (firstPlayerPoints == 2) {
            firstPlayerScore = "30";
        } else if (firstPlayerPoints == 3) {
            firstPlayerScore = "40";
        }
        this.score = firstPlayerScore + " : Love";
        return score;
    }

    public void firstPlayerGetAPoint() {
        firstPlayerPoints++;
    }
}
