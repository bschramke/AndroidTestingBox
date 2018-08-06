package com.github.bschramke.android.testing.jgiven.steps;

import android.support.test.rule.ActivityTestRule;

import com.github.bschramke.android.testing.jgiven.R;
import com.github.bschramke.android.testing.sample.CalculatorActivity;
import com.tngtech.jgiven.CurrentStep;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Quoted;
import com.tngtech.jgiven.annotation.ScenarioState;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayingAtLeast;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class CalculatorSteps extends Stage<CalculatorSteps> {
    @ScenarioState
    CurrentStep currentStep;

    @ScenarioState
    ActivityTestRule<CalculatorActivity> activityTestRule;

    public CalculatorSteps I_see_the_Calculator_screen() {
        // nothing to do, just for reporting
        return this;
    }

    public CalculatorSteps I_press_the_button_$(int arg0) {
        onView(withText(String.valueOf(arg0)))
                .check(matches(isDisplayingAtLeast(90)))
                .perform(click());
        return this;
    }

    public CalculatorSteps I_should_see_the_value_$_displayed(int arg0) {
        onView(withId(com.github.bschramke.android.testing.sample.R.id.calculatorDisplay)).check(matches(withText(String.valueOf(arg0))));
        takeScreenshot();
        return this;
    }
    private void takeScreenshot() {
//        currentStep.addAttachment(
//                Attachment.fromBinaryBytes(ScreenshotUtil.takeScreenshot(activityTestRule.getActivity()), MediaType.PNG)
//                        .showDirectly()) ;
    }

}
