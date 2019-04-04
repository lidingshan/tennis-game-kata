package kata.odde.com;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TennisGameSteps {

    private final TennisGame game = new TennisGame();

    @Given("^a new game$")
    public void a_new_game() throws Throwable {
    }

    @Then("^the score should be \"(.*?)\"$")
    public void the_score_should_be(String expected) throws Throwable {
        Assert.assertEquals(expected, game.getScore());
    }

    @When("^first player got (\\d+) of points$")
    public void first_player_got_point(int points) throws Throwable {
        for (int i = 0; i < points; i++) {
            game.firstPlayerGetAPoint();
        }
    }
}
