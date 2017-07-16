package com.revolut.qa.entries.auth.message;

import com.revolut.qa.entries.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static ru.sbtqa.tag.pagefactory.PageFactory.getDriver;
import static ru.sbtqa.tag.pagefactory.PageFactory.initElements;
import static ru.sbtqa.tag.pagefactory.extensions.DriverExtension.waitUntilElementPresent;

/**
 * Developed by sokovets-av
 */
@Slf4j
public class ChooseBalanceMsg extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Other']")
    private WebElement other;

    public ChooseBalanceMsg() {
        initElements(getDriver(), this);
        waitUntilElementPresent(other);
        log.info("Opened Choose Balance Massage");
    }

    public final void chooseBalance(String currency) {
        getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text, '" + currency + "')]")).click();
    }

}
