package com.revolut.qa.entries.transfer;

import com.revolut.qa.entries.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

import static ru.sbtqa.tag.pagefactory.PageFactory.getDriver;
import static ru.sbtqa.tag.pagefactory.PageFactory.initElements;

/**
 * Developed by sokovets-av
 */
@Slf4j
@PageEntry(title = "Transfer speed")
public class TransferSpeedPage extends BasePage {

    @ElementTitle(value = "Total Cost")
    @FindBy(id = "com.revolut.revolut.test:id/total_cost")
    private WebElement totalCost;

    @ElementTitle(value = "Send")
    @FindBy(xpath = "//android.widget.Button[@text='Send']")
    protected WebElement send;

    public TransferSpeedPage() {
        initElements(getDriver(), this);
        log.info("Opened Transfer Speed Page");
    }


}
