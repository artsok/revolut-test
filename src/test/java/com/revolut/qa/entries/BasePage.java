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
import ru.sbtqa.tag.qautils.strategies.MatchStrategy;

import static ru.sbtqa.tag.pagefactory.PageFactory.getDriver;
import static ru.sbtqa.tag.pagefactory.PageFactory.getMobileDriver;
import static ru.sbtqa.tag.pagefactory.extensions.MobileExtension.swipeToText;
import static ru.sbtqa.tag.qautils.strategies.DirectionStrategy.DOWN;

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

    @ElementTitle(value = "Save")
    @FindBy(xpath = "//android.widget.Button[@text='Save']")
    protected WebElement save;

    /**
     * Choose webelement with swipe
     * @param swipeToText
     * @param by
     * @throws SwipeException
     */
    protected final void chooseItemWithSwipe(String swipeToText, By by) throws SwipeException {
        swipeToText(DOWN, swipeToText, MatchStrategy.CONTAINS);
        WebElement element = getDriver().findElement(by);
        clickWebElement(element);
    }

    /**
     * Send keys to field
     * @param elementTitle {@link String}
     * @param text {@link String}
     * @throws PageException
     */
    @Override
    public void fillField(String elementTitle, String text) throws PageException {
        WebElement webElement = getElementByTitle(elementTitle);
        webElement.clear();
        webElement.click();
        getMobileDriver().getKeyboard().sendKeys(text);
        log.info("Filling field on WebElement with tagName - '{}' with text '{}'", webElement.getTagName(), text);
    }

    /**
     * Click to the webelement
     * @param webElement {@link WebElement}
     */
    @Override
    public void clickWebElement(WebElement webElement) {
        log.info("Clicking on WebElement with tagName - '{}'", webElement.getTagName());
        super.clickWebElement(webElement);
    }

    /**
     * Save value to HashMap
     * @param dataTable {@link DataTable}
     */
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
