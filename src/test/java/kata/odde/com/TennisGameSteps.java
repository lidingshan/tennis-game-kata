package kata.odde.com;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class TennisGameSteps {

    private int _result;

    @Given("^(\\d+) and (\\d+)$")
    public void and(int arg1, int arg2) throws Throwable {
        this._result = arg1 + arg2;
    }

    @Then("^should get (\\d+)$")
    public void should_get(int arg1) throws Throwable {
        Assert.assertEquals(this._result, arg1);
    }
}
