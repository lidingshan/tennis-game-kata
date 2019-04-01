package kata.odde.com;

import java.util.ArrayList;

public class TennisGame {
    private ArrayList<Player> _players;
    private String _name;
    private String[] _score;

    public void setName(String name) {
        this._name = name;
    }

    public TennisGame() {
        this._players = new ArrayList<Player>();
        this._score = new String[] {"0", "15", "30", "40", "Advantage"};
    }

    public String getName() {
        return _name;
    }

    public void addPlayer(String player_name) {
        Player newPlayer = new Player(player_name, this._players.size());
        this._players.add(newPlayer);
    }

    public Player getPlayer(int index) {
        return this._players.get(index);
    }

    public void addOnePointToPlayer(String name) {
        Player player = this.getPlayerByName(name);
        player.winOnePoint();
   }

   public String getPlayerScore(Player player) {

        Player opposite = this._players.get(_players.size() - player.getIndex() - 1);
        if (!player.hasAtLeastThreePoints()) {
            return _score[player.getWonPoints()];
        }
        if (player.getWonPoints() > opposite.getWonPoints()) {
            if (player.getWonPoints() - opposite.getWonPoints() == 1) {
                return "Advantage";
            } else {
                return "40";
            }

        } else if (player.getWonPoints() < opposite.getWonPoints()) {
            return "40";
        } else {
            return "Deuce";
        }
   }

   public Player getPlayerByName(String name) {
        for (Player player : this._players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }

        return null;
    }

    public String getWinnerName() {
        Player player1 = _players.get(0);
        Player player2 = _players.get(1);

        String winnerName = "unknown";
        if (isLeadAtLeastTwoPoints(player1, player2)
                && (player1.getWonPoints()>3 || player2.getWonPoints()>3)) {
            winnerName = player1.getWonPoints() > player2.getWonPoints() ? player1.getName() : player2.getName();
        }

        return winnerName;
    }

    private boolean isLeadAtLeastTwoPoints(Player player1, Player player2) {
        return Math.abs(player1.getWonPoints() - player2.getWonPoints()) >=2;
    }

    public class Player {
        private String _name;
        private Integer _wonPoints;

        private Integer _index;

        public Player(String name, Integer index) {
            this._name = name;
            this._wonPoints = 0;
            this._index = index;
        }

        public String getName() {
            return _name;
        }


        public void winOnePoint() {
           _wonPoints++;
        }

        public int getWonPoints() {
            return _wonPoints;
        }

        public boolean hasAtLeastThreePoints() {
            return _wonPoints >= 3;
        }

        public Integer getIndex() {
            return _index;
        }
    }
}
