package com.github.bschramke.android.testing.jgiven;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.github.bschramke.android.testing.jgiven.steps.CalculatorSteps;
import com.github.bschramke.android.testing.sample.CalculatorActivity;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.tngtech.jgiven.integration.android.AndroidJGivenTestRule;
import com.tngtech.jgiven.junit.SimpleScenarioTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest extends SimpleScenarioTest<CalculatorSteps>{

    @Rule
    @ScenarioState
    public ActivityTestRule<CalculatorActivity> activityTestRule = new ActivityTestRule<>(CalculatorActivity.class);

    @Rule
    public AndroidJGivenTestRule androidJGivenTestRule = new AndroidJGivenTestRule(this.getScenario());

    @Test
    public void clicking_digit_buttons_shows_number_in_display() {
        given().I_see_the_Calculator_screen();
        when().I_press_the_button_$(4)
                .and().I_press_the_button_$(2);
        then().I_should_see_the_value_$_displayed(42);

    }

}
