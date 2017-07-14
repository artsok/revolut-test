package com.revolut.qa.stepdefs;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.qautils.properties.Props;

/**
 * Developed by sokovets-av
 */
@Slf4j
public class CommonStepDefs {

    @And("^user clearing cash.*$")
    public void clearCaches() {
        ((AndroidDriver) PageFactory.getMobileDriver()).resetApp();
    }

    @And("^user closing application.*$")
    public void closeApp() {
        ((AndroidDriver) PageFactory.getMobileDriver()).closeApp();
    }

    @And("^user starting application.*$")
    public void openApp() {
        ((AndroidDriver) PageFactory.getMobileDriver()).startActivity(Props.get("appium.app.package"), Props.get("appium.app.activity"));
    }

    @Before()
    public void setUp() {
        clearCaches();
    }


}
