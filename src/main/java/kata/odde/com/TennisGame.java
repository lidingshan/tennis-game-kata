package kata.odde.com;

import java.util.ArrayList;

public class TennisGame {
    private ArrayList<Player> _players;
    private String _name;

    public void setName(String name) {
        this._name = name;
    }

    public TennisGame() {
        this._players = new ArrayList<Player>();
    }

    public String getName() {
        return _name;
    }

    public void addPlayer(String player_name) {
        Player newPlayer = new Player(player_name);
        this._players.add(newPlayer);
    }

    public Player getPlayer(int index) {
        return this._players.get(index);
    }

    public void addOnePointToPlayer(String name) {
        Player player = this.getPlayerByName(name);
        player.winOnePoint();

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
        if (Math.abs(player1.getWonPoints() - player2.getWonPoints()) >=2 ) {
            winnerName = player1.getWonPoints() > player2.getWonPoints() ? player1.getName() : player2.getName();
        }

        return winnerName;
    }

    public class Player {
        private String _name;
        private String[] _score;
        private Integer _wonPoints;

        public Player(String name) {
            this._name = name;
            this._score = new String[] {"0", "15", "30", "40", "Deuce"};
            this._wonPoints = 0;
        }

        public String getName() {
            return _name;
        }

        public String getScore() {
            return _score[_wonPoints].toString();
        }

        public void winOnePoint() {
           _wonPoints++;
        }

        public int getWonPoints() {
            return _wonPoints;
        }
    }
}
