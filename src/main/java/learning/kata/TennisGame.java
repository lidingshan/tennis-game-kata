package learning.kata;

public class TennisGame {

    private final int DEUCE_POINT = 3;
    private final int AD_POINT = 4;

    class Player {
        private int points = 0;
        private boolean serving = false;

        public void winOnePoint() {
            this.points++;
        }

        public int getPoints() {
            return this.points;
        }

        public void setServing() {
            this.serving = true;
        }

        public boolean getServing() {
            return this.serving;
        }
    }

    private Player[] players = {new Player(), new Player()};
    private String[] scores = {"LOVE", "FIFTEEN", "THIRTY", "FORTY"};

    public String getScore() {

        if (isDeuce())
            return "DEUCE";

        if (isAll())
            return this.scores[this.players[0].getPoints()] + " ALL";

        Player validAdPlayer = this.getAdvantageIfValid();
        if (validAdPlayer != null)
            return setAdvantageText(validAdPlayer);

        return this.scores[this.players[0].getPoints()] + ":" + this.scores[this.players[1].getPoints()];
    }

    private boolean isAll() {
        return this.players[0].getPoints() == this.players[1].getPoints() && this.players[0].getPoints() < DEUCE_POINT;
    }

    private boolean isDeuce() {
        return this.players[0].getPoints() == this.players[1].getPoints() && this.players[0].getPoints() >= DEUCE_POINT;
    }

    public void serveByPlayer(int playerIndex) {
        Player player = this.players[playerIndex-1];
        player.setServing();
    }

    public void winOnePoint(int player) {
        this.players[player-1].winOnePoint();
    }

    private Player getAdvantageIfValid() {
        if (Math.abs(this.players[0].getPoints() - this.players[1].getPoints()) == 1) {
            Player adPlayer = this.players[0].getPoints() > this.players[1].getPoints() ? this.players[0] : this.players[1];
            return adPlayer.getPoints() >= AD_POINT ? adPlayer : null;
        }
        return null;
    }

    private String setAdvantageText(Player player) {
        return player.getServing() ? "AD-IN" : "AD-OUT";
    }

}
