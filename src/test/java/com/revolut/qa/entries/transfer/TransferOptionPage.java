package com.revolut.qa.entries.transfer;

import com.revolut.qa.entries.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

import static ru.sbtqa.tag.pagefactory.PageFactory.getDriver;
import static ru.sbtqa.tag.pagefactory.PageFactory.initElements;

/**
 * Developed by sokovets-av
 */
@PageEntry(title = "Choose the transfer option")
public class TransferOptionPage extends BasePage {

    @ElementTitle(value = "To bank account")
    @FindBy(xpath = "//android.widget.TextView[@text='To bank account']")
    private WebElement toBankAccount;

    public TransferOptionPage() {
        initElements(getDriver(), this);
    }
}
