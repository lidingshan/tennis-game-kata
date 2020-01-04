package learning.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class TennisGameTest {

    private TennisGame game;

    @BeforeEach
    void setUp() {
        game = new TennisGame();
    }

    @Test
    public void new_game_should_be_set() {
        assertThat(game.getScore()).isEqualTo("LOVE ALL");
    }

    @Test
    public void player_one_win_1_ball() {
        int player = 1;
        game.winOnePoint(player);

        assertThat(game.getScore()).isEqualTo("FIFTEEN:LOVE");
    }

    @Test
    public void player_one_win_2_points() {
        int player = 1;
        setPlayerPoints(player, 2);

        assertThat(game.getScore()).isEqualTo("THIRTY:LOVE");
    }

    private void setPlayerPoints(int player, int points) {
        for (int i = 0; i < points; i++) {
            game.winOnePoint(player);
        }
    }

    @Test
    public void player_one_win_3_points() {
        int player = 1;
        setPlayerPoints(1, 3);
        assertThat(game.getScore()).isEqualTo("FORTY:LOVE");
    }

    @Test
    public void player_two_win_1_points() {
        int player = 2;
        game.winOnePoint(2);
        assertThat(game.getScore()).isEqualTo("LOVE:FIFTEEN");
    }

    @Test
    public void both_player_win_2_points() {
        setPlayerPoints(1, 2);
        setPlayerPoints(2, 2);
        assertThat(game.getScore()).isEqualTo("THIRTY ALL");
    }

    @Test
    public void both_player_win_3_points() {
        setPlayerPoints(1, 3);
        setPlayerPoints(2, 3);
        assertThat(game.getScore()).isEqualTo("DEUCE");
    }

    @Test
    public void both_players_win_4_points() {
        setPlayerPoints(1, 4);
        setPlayerPoints(2, 4);
        assertThat(game.getScore()).isEqualTo("DEUCE");
    }

    @Test
    public void player_one_and_win_6_points_and_player_two_serve_and_win_5_points() {
        game.serveByPlayer(2);
        setPlayerPoints(1, 6);
        setPlayerPoints(2, 5);
        assertThat(game.getScore()).isEqualTo("AD-OUT");
    }

    @Test
    public void player_one_serve_and_win_1_point_when_deuce() {
        game.serveByPlayer(1);
        setPlayerPoints(1, 5);
        setPlayerPoints(2, 4);
        assertThat(game.getScore()).isEqualTo("AD-IN");
    }

    @Test
    public void player_two_serve_and_win_1_point_when_deuce() {
        game.serveByPlayer(2);
        setPlayerPoints(1, 4);
        setPlayerPoints(2, 5);
        assertThat(game.getScore()).isEqualTo("AD-IN");
    }

    @Test
    public void player_two_serve_and_player_one_win_1_point_when_deuce() {
        game.serveByPlayer(2);
        setPlayerPoints(1, 5);
        setPlayerPoints(2, 4);
        assertThat(game.getScore()).isEqualTo("AD-OUT");
    }
}
