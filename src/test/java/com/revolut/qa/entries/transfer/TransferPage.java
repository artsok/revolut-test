package com.revolut.qa.entries.transfer;

import com.revolut.qa.entries.BasePage;
import com.revolut.qa.entries.auth.message.ChooseBalanceMsg;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

import static ru.sbtqa.tag.pagefactory.PageFactory.getDriver;
import static ru.sbtqa.tag.pagefactory.PageFactory.initElements;
import static ru.sbtqa.tag.pagefactory.extensions.DriverExtension.waitUntilElementPresent;

/**
 * Developed by sokovets-av
 */
@Slf4j
@PageEntry(title = "Transfer")
public class TransferPage extends BasePage {

    @FindBy(id = "com.revolut.revolut.test:id/bank_logo_icon")
    private WebElement bankLogo;

    @ElementTitle(value = "Amount")
    @FindBy(id = "com.revolut.revolut.test:id/edit_text_amount")
    private WebElement sendAmount;

    @ElementTitle(value = "Continue")
    @FindBy(xpath = "//android.widget.Button[@text='Continue']")
    protected WebElement continueBtn;

    public TransferPage() {
        initElements(getDriver(), this);
        waitUntilElementPresent(bankLogo);
        log.info("Opened Transfer Page");
    }

    @ActionTitle("selecting balance")
    public void selectBalance(String currency) {
        getDriver().findElement(By.id("com.revolut.revolut.test:id/arrow_down")).click();
        ChooseBalanceMsg cbMsg = new ChooseBalanceMsg();
        cbMsg.chooseBalance(currency);
    }



}
