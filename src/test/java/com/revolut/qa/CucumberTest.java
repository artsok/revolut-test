package com.revolut.qa;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import ru.sbtqa.tag.cucumber.TagCucumber;

/**
 * Developed by sokovets-av
 */
@RunWith(TagCucumber.class)
@CucumberOptions(monochrome = true, format = {"pretty"},
      glue = {"ru.sbtqa.tag.pagefactory.stepdefs", "com.revolut.qa.stepdefs"},
      features = {"src/test/resources/features/"},
      tags = {"@5"}
)
public class CucumberTest {

}
