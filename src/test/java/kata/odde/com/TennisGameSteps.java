package kata.odde.com;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class TennisGameSteps {

    private final TennisGame game = new TennisGame();

    @Given("^a new game$")
    public void a_new_game() throws Throwable {
    }

    @Then("^the score should be \"(.*?)\"$")
    public void the_score_should_be(String arg1) throws Throwable {
        Assert.assertEquals(arg1, game.getScore());
    }

}
