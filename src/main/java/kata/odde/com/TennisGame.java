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

    public void addOnePointToPlayer(int index) {
        this._players.get(index).winOnePoint();
    }

    public class Player {
        private String _name;
        private Integer _score;

        public Player(String name) {
            this._name = name;
            this._score = 0;
        }

        public String getName() {
            return _name;
        }

        public int getScore() {
            return _score;
        }

        public void winOnePoint() {
            _score = 15;
        }
    }
}
