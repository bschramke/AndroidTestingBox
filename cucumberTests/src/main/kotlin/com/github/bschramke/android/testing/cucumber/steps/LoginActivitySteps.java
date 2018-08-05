package com.github.bschramke.android.testing.cucumber.steps;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.app.AppCompatActivity;

import com.github.bschramke.android.testing.sample.CalculatorActivity;

import org.junit.Rule;
import org.junit.runner.RunWith;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.android.api.Assertions.assertThat;

public class LoginActivitySteps {

    @Rule
    public ActivityTestRule<CalculatorActivity> activityTestRule = new ActivityTestRule<>(CalculatorActivity.class, false, false);
    private AppCompatActivity activity;

    @Before
    public void setup() {
        activity = activityTestRule.launchActivity(new Intent());
        assertThat(activity).isNotNull();
    }

    @After
    public void tearDown() {
        activityTestRule.finishActivity();
    }

    @Given("^I see the Calculator screen$")
    public void iSeeTheCalculatorScreen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I press the button (\\d+)$")
    public void iPressTheButton(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should see the value (\\d+) displayed$")
    public void iShouldSeeTheValueDisplayed(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
