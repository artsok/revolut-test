package com.revolut.qa.entries;

import cucumber.api.DataTable;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.datajack.Stash;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.pagefactory.exceptions.SwipeException;
import ru.sbtqa.tag.qautils.strategies.DirectionStrategy;
import ru.sbtqa.tag.qautils.strategies.MatchStrategy;

import static ru.sbtqa.tag.pagefactory.PageFactory.getDriver;
import static ru.sbtqa.tag.pagefactory.PageFactory.getMobileDriver;
import static ru.sbtqa.tag.pagefactory.extensions.MobileExtension.swipeToText;

/**
 * Developed by sokovets-av
 */
@Slf4j
public class BasePage extends Page {

    @ElementTitle(value = "Next")
    @FindBy(xpath = "//android.widget.Button[@text='Next']")
    protected WebElement next;

    @ElementTitle(value = "Done")
    @FindBy(xpath = "//android.widget.Button[@text='Done']")
    protected WebElement done;

    @ElementTitle(value = "Skip")
    @FindBy(xpath = "//android.widget.Button[@text='Skip']")
    protected WebElement skip;

    protected final void chooseItemWithSwipe(String swipeToText, By by) throws SwipeException {
        swipeToText(DirectionStrategy.DOWN, swipeToText, MatchStrategy.CONTAINS);
        WebElement element = getDriver().findElement(by);
        clickWebElement(element);
    }

    @Override
    public void fillField(String elementTitle, String text) throws PageException {
        WebElement webElement = getElementByTitle(elementTitle);
        webElement.clear();
        webElement.click();
        getMobileDriver().getKeyboard().sendKeys(text);
    }

    @ActionTitle("save temp values to stash")
    public final void saveToStash(DataTable dataTable) {
        dataTable.asList(String.class).forEach(element -> {
            try {
                String value = getElementByTitle(element).getText();
                Stash.put(element, value);
                log.info("Save value to stash: '{}' with name '{}'", value, element);
            } catch (PageException e) {
                log.error("Error at save to stash operation", e);
            }
        });
    }


}
