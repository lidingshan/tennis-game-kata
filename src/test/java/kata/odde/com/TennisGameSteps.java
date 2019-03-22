package kata.odde.com;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import cucumber.api.java.Before;

public class TennisGameSteps {

    private TennisGame game;

    @Before()
    public void Setup() {
        game = new TennisGame();
    }

    @Given("^start a new game with the name \"(.*?)\"")
    public void start_a_new_game_with(String name) throws Throwable {
        game.setName(name);
   }

    @Then("^the game name should be \"(.*?)\"$")
    public void the_game_name_should_be(String name) throws Throwable {
        Assert.assertEquals(name, game.getName());
     }

    @Given("^two players (.*?) and (.*?) in the game$")
    public void two_players_Tom_and_Jerry_in_the_game(String player1, String player2) throws Throwable {
        game.addPlayer(player1);
        game.addPlayer(player2);
    }

    @And("^both of them should have score (\\d+)$")
    public void both_of_them_should_have_score(int arg1) throws Throwable {
        Assert.assertEquals(0, game.getPlayer(0).getScore());
        Assert.assertEquals(0, game.getPlayer(1).getScore());
    }

    @Then("^the game should have two players \"(.*?)\" an \"(.*?)\"$")
    public void the_game_should_have_two_players_an(String name1, String name2) throws Throwable {
        Assert.assertEquals(name1, game.getPlayer(0).getName());
        Assert.assertEquals(name2, game.getPlayer(1).getName());
    }

    @Given("^(.*?) and (.*?) start the name$")
    public void tom_and_Jerry_start_the_name(String name1, String name2) throws Throwable {
        game.addPlayer(name1);
        game.addPlayer(name2);
    }

    @When("^Tom get one point$")
    public void tom_get_one_point() throws Throwable {
        game.addOnePointToPlayer(0);
    }

    @Then("^Tom score is (\\d+)$")
    public void tom_score_is(int score) throws Throwable {
        Assert.assertEquals(score, game.getPlayer(0).getScore());
    }

}
