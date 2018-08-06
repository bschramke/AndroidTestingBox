package com.github.bschramke.android.testing.sample.test.actions;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;

import com.squareup.spoon.Spoon;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.io.File;

import javax.annotation.Nonnull;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;

/**
 * Class to take screenshots using Spoon library from an Espresso test
 * Original code from Gist: https://gist.github.com/edenman/7fdd32a4d59ccc01185b
 */
public class ScreenshotAction implements ViewAction {

    private static File lastScreenshot;
    private final String mTag;
    private final String mTestClass;
    private final String mTestMethod;

    /**
     * Initialize with information required to take a screenshot
     *
     * @param tag        Name of the screenshot to include in the file name
     * @param testClass  Name of the class taking the screenshot (required by Spoon library)
     * @param testMethod Name of the method taking the screenshot
     */
    private ScreenshotAction(final String tag, final String testClass, final String testMethod) {
        mTag = tag;
        mTestClass = testClass;
        mTestMethod = testMethod;
    }

    @Override
    public Matcher<View> getConstraints() {
        return Matchers.any(View.class);
    }

    @Override
    public String getDescription() {
        return "Taking a screenshot using spoon.";
    }

    @Override
    public void perform(UiController uiController, View view) {
        lastScreenshot = Spoon.screenshot(getActivity(view), mTag, mTestClass, mTestMethod);
    }

    /**
     * Get the last captured screenshot file
     *
     * @return Last screenshot file handler or null if there was no screenshot taken
     */
    public static File getLastScreenshot() {
        return lastScreenshot;
    }

    /**
     * Get the activity from the context of the view
     *
     * @param view View from which the activity will be inferred
     * @return Activity that contains the given view
     */
    private static Activity getActivity(final View view) {
        return scanForActivity(view.findViewById(android.R.id.content).getContext());
    }

    private static Activity scanForActivity(Context ctx) {
        if (ctx == null)
            return null;
        else if (ctx instanceof Activity)
            return (Activity)ctx;
        else if (ctx instanceof ContextWrapper)
            return scanForActivity(((ContextWrapper)ctx).getBaseContext());

        return null;
    }

    /**
     * Espresso action to be take a screenshot of the current activity
     * This must be called directly from the test method
     *
     * @param tag Name of the screenshot to include in the file name
     */
    public static void perform(final String tag) {
        final StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        final String testClass = trace[3].getClassName();
        final String testMethod = trace[3].getMethodName();
        perform(tag,testClass,testMethod);
    }

    /**
     * Espresso action to be take a screenshot of the current activity
     * This must be called directly from the test method
     *
     * @param tag Name of the screenshot to include in the file name
     * @param testClass  Name of the class taking the screenshot (required by Spoon library)
     * @param testMethod Name of the method taking the screenshot
     */
    public static void perform(final String tag, @Nonnull final String testClass, @Nonnull final String testMethod) {
        onView(isRoot()).perform(new ScreenshotAction(tag, testClass, testMethod));
    }

}
