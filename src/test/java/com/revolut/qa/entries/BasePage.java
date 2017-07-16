package com.revolut.qa.entries;

import cucumber.api.DataTable;
import io.appium.java_client.android.AndroidElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.datajack.Stash;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.pagefactory.exceptions.SwipeException;
import ru.sbtqa.tag.qautils.errors.AutotestError;
import ru.sbtqa.tag.qautils.strategies.DirectionStrategy;
import ru.sbtqa.tag.qautils.strategies.MatchStrategy;

import java.util.*;

import static ru.sbtqa.tag.pagefactory.PageFactory.getDriver;
import static ru.sbtqa.tag.pagefactory.PageFactory.getMobileDriver;
import static ru.sbtqa.tag.pagefactory.extensions.MobileExtension.swipe;
import static ru.sbtqa.tag.pagefactory.extensions.MobileExtension.swipeToText;
import static ru.sbtqa.tag.qautils.strategies.DirectionStrategy.*;

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
        swipeToText(DOWN, swipeToText, MatchStrategy.CONTAINS);
        WebElement element = getDriver().findElement(by);
        clickWebElement(element);
    }

    @Override
    public void fillField(String elementTitle, String text) throws PageException {
        WebElement webElement = getElementByTitle(elementTitle);
        webElement.clear();
        webElement.click();
        getMobileDriver().getKeyboard().sendKeys(text);
        log.info("Filling field on WebElement with tagName - '{}' with text '{}'", webElement.getTagName(), text);
    }

    @Override
    public void clickWebElement(WebElement webElement) {
        log.info("Clicking on WebElement with tagName - '{}'", webElement.getTagName());
        super.clickWebElement(webElement);
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

    ////android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Errrroi')]

    public final int countOfElements(By identifier, String lastNameOfElementInList) throws SwipeException {
        Set<String> idSet = new HashSet<>();
        WebElement element = null;


//        for (int i = 0; i < 256 && element == null; i++) {
//            List<WebElement> webElementList = getDriver().findElements(identifier);
//            webElementList.forEach(webElement -> {
//                System.out.println("sdfsdfsdf sdf "  + ((RemoteWebElement) webElement).getId());
//                idSet.add(((RemoteWebElement) webElement).getId());
//            });
//            element = swipeToElement(lastNameOfElementInList, DOWN);
//        }
        return idSet.size();
    }

    public final WebElement swipeToElement(String xpath, DirectionStrategy direction) throws SwipeException {
        Set<String> idSet = new HashSet<>();
        for (int depthCounter = 0; depthCounter < 256; depthCounter++) {
            String oldPageSource = getDriver().getPageSource();

            List<WebElement> webElementList = getDriver().findElements(By.id("com.revolut.revolut.test:id/item_title"));
            webElementList.forEach(webElement -> {
                System.out.println("sdfsdfsdf sdf "  + ((RemoteWebElement) webElement).getId());
                idSet.add(((RemoteWebElement) webElement).getId());
            });

            List<WebElement> elements = getDriver().findElements(By.xpath(xpath));
            if (elements.size() > 0) {
                System.out.println("alaaaa size" + idSet.size());
                return elements.get(0);
            }
            swipe(direction);

            if (getDriver().getPageSource().equals(oldPageSource)) {
                throw new SwipeException("Swiping limit is reached. Text not found");
            }
        }
        throw new SwipeException("Swiping depth is reached. Text not found");
    }


    public int toGetContentsInListView(By by) {

//Since i need unique set of elements i am using Set
        Set<String> contentsCount = new HashSet<String>();

//Take the count of the contents displayed on screen


        List<WebElement> webElementList = getMobileDriver().findElements(by);
        int contents = webElementList.size();
        if (contents == 0) {
            throw new AutotestError("No elements to found");
        }

        for (int i = 0; i < contents; i++) {
            String dataDisplayed = webElementList.get(i).getText();
            contentsCount.add(dataDisplayed);
        }
        scrollDown();
        for (int i = 0; i < contents; i++) {
            String dataToRestore = webElementList.get(i).getText();
            //contentsCount.add(dataDisplayed);
        }
        int contentSize = contentsCount.size();

        return contentSize;
    }

    public static void scrollDown() {
        try {
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            RemoteWebElement element = (RemoteWebElement) getMobileDriver().findElementByClassName("android.widget.ListView");
            JavascriptExecutor js = (JavascriptExecutor) getMobileDriver();
            String widId = ((RemoteWebElement) element).getId();
            scrollObject.put("text", "LastElementInList");
            scrollObject.put("element", widId);
            js.executeScript("mobile: scrollTo", scrollObject);
        } catch (Exception e) {
        }
    }


}
