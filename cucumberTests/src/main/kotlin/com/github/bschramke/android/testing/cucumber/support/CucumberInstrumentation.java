package com.github.bschramke.android.testing.cucumber.support;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.MonitoringInstrumentation;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.android.CucumberInstrumentationCore;

@CucumberOptions(
        features = "features",
        glue = "com.github.bschramke.android.testing.cucumber",
        plugin = { "pretty"})
public class CucumberInstrumentation extends MonitoringInstrumentation {
    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(Bundle arguments) {
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
