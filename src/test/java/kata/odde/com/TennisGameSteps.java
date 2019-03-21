package kata.odde.com;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.junit.Before;

public class TennisGameSteps {

    private TennisGame game;

    @Given("^two players Tom and Jerry$")
    public void two_players_Tom_and_Jerry() throws Throwable {
        game = new TennisGame();
   }

    @Then("^both of them have (\\d+) score$")
    public void both_of_them_have_score(int arg1) throws Throwable {
        Assert.assertEquals(0, game.score.get(0).intValue());
        Assert.assertEquals(0, game.score.get(1).intValue());
     }

}
