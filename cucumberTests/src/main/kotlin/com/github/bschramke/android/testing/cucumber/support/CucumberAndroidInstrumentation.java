package com.github.bschramke.android.testing.cucumber.support;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnitRunner;
import android.support.test.runner.MonitoringInstrumentation;

import cucumber.api.CucumberOptions;
import cucumber.api.android.CucumberInstrumentationCore;

/**
 * Used in build.gradle/testInstrumentationRunner to run Cucumber tests
 * 'testInstrumentationRunner' variable in build.gradle has to point to this package
 * This class must be in a different package than the glue code
 * (this class is in '...cucumber.runner' and glue is in '...cucumber.steps')
 *
 *  {@see https://github.com/sebaslogen/CleanGUITestArchitecture/blob/master/app/src/androidTest/java/com/neoranga55/cleanguitestarchitecture/cucumber/runner/CucumberTestRunner.java}
 */
public class CucumberAndroidInstrumentation extends MonitoringInstrumentation{
    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(final Bundle arguments) {
        super.onCreate(arguments);
        instrumentationCore.create(arguments);
        start();
    }

    @Override
    public void onStart() {
        super.onStart();
        waitForIdleSync();
        instrumentationCore.start();
    }
}
