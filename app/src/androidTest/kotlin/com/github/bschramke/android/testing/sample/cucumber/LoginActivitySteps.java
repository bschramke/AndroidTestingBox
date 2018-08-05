package com.github.bschramke.android.testing.sample.cucumber;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.app.AppCompatActivity;

import com.github.bschramke.android.testing.sample.CalculatorActivity;
import com.github.bschramke.android.testing.sample.R;
import com.squareup.spoon.Spoon;

import org.junit.Rule;

import java.io.File;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayingAtLeast;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.assertj.android.api.Assertions.assertThat;

public class LoginActivitySteps {

    @Rule
    public ActivityTestRule<CalculatorActivity> activityTestRule = new ActivityTestRule<>(CalculatorActivity.class, false, false);
    private AppCompatActivity activity;

    @Before
    public void setup() {
        activity = activityTestRule.launchActivity(new Intent());
    }

    @After
    public void tearDown() {
        activityTestRule.finishActivity();
    }

    @Given("^I see the Calculator screen$")
    public void iSeeTheCalculatorScreen() {
        assertThat(activity)
                .isNotNull()
                .isInstanceOf(CalculatorActivity.class);
        onView(withId(R.id.calculatorDisplay)).check(matches(isDisplayingAtLeast(90)));
    }

    @When("^I press the button (\\d+)$")
    public void iPressTheButton(int arg0) {
        onView(withText(String.valueOf(arg0)))
                .check(matches(isDisplayingAtLeast(90)))
                .perform(click());
    }

    @Then("^I should see the value (\\d+) displayed$")
    public void iShouldSeeTheValueDisplayed(int arg0) {
        onView(withId(R.id.calculatorDisplay)).check(matches(withText(String.valueOf(arg0))));
    }

}
