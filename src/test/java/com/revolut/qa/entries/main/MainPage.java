package com.revolut.qa.entries.main;

import com.revolut.qa.entries.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;
import static ru.sbtqa.tag.pagefactory.PageFactory.getDriver;
import static ru.sbtqa.tag.pagefactory.PageFactory.initElements;
import static ru.sbtqa.tag.pagefactory.extensions.DriverExtension.waitUntilElementGetInvisible;
import static ru.sbtqa.tag.pagefactory.extensions.DriverExtension.waitUntilElementPresent;

/**
 * Developed by sokovets-av
 */
@Slf4j
@PageEntry(title = "Main Activity")
public class MainPage extends BasePage {

    @ElementTitle(value = "Purple Transfer")
    @FindBy(id = "com.revolut.revolut.test:id/button_transfer")
    private WebElement transferOptionBtn;

    @FindBy(id = "com.revolut.revolut.test:id/amount_int_dot")
    private WebElement amountDot;

    @FindBy(xpath = "//android.widget.TextSwitcher[@resource-id='com.revolut.revolut.test:id/amount_int']/android.widget.TextView")
    private WebElement amountInt;

    @FindBy(xpath = "//android.widget.TextSwitcher[@resource-id='com.revolut.revolut.test:id/amount_fractional']/android.widget.TextView")
    private WebElement amountFractional;

    @FindBy(id = "com.revolut.revolut.test:id/list_transactions_progress")
    private WebElement progressBar;

    public MainPage() {
        initElements(getDriver(), this);
        waitUntilElementPresent(transferOptionBtn);
        log.debug("Opened Main Page");
    }

    /**
     * Get total amount from main page
     * @return {@link String}
     */
    @ActionTitle("get total amount")
    public final String getAmount()  {
        String totalAmount = amountInt.getText() + amountDot.getText() + amountFractional.getText();
        log.info("Total amount '{}'", totalAmount);
        return totalAmount;
    }

    /**
     * Choose transfer type
     * @param option {@link String}
     */
    @ActionTitle("choosing transfer type")
    public final void chooseTransferOption(String option) {
        final String element = "//android.widget.TextView[@text='%s']";
        clickWebElement(getDriver().findElement(xpath(format(element, option))));
        log.info("Choosed transfer type '{}'", option);
    }



}
