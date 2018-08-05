package com.github.bschramke.android.testing.sample.cucumber;

import android.os.Bundle;
import android.support.test.runner.MonitoringInstrumentation;

import cucumber.api.CucumberOptions;
import cucumber.api.android.CucumberInstrumentationCore;

/**
 * Used in build.gradle/testInstrumentationRunner to run Cucumber tests
 * 'testInstrumentationRunner' variable in build.gradle has to point to this package
 * This class must be in a different package than the glue code
 * (this class is in '...cucumber.runner' and glue is in '...cucumber.steps')
 *
 *  {@see https://github.com/emmasuzuki/CucumberEspressoDemo}
 */
@CucumberOptions(
        features = "features",
        glue = "com.github.bschramke.android.testing.sample.cucumber",
        plugin = {"pretty",
                // Cucumber report formats and location to store them in phone/emulator
                "html:/mnt/sdcard/cucumber-reports/cucumber-html-report",
                "json:/mnt/sdcard/cucumber-reports/cucumber.json",
                "junit:/mnt/sdcard/cucumber-reports/cucumber.xml"
                // Note: if you don't have write access to /mnt/sdcard/
        }
)
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
