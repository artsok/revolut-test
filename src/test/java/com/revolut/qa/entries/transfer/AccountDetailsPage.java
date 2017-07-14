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
@PageEntry(title = "Fill into account details")
public class AccountDetailsPage extends BasePage {

    @ElementTitle(value = "Legal first name")
    @FindBy(id = "com.revolut.revolut.test:id/first_name")
    private WebElement firstName;

    @ElementTitle(value = "Legal last name")
    @FindBy(id = "com.revolut.revolut.test:id/last_name")
    private WebElement lastName;

    @ElementTitle(value = "IBAN/Account number")
    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.revolut.revolut.test:id/account_item_container']/android.widget.EditText[@index=0]")
    private WebElement accountNumber;

    @ElementTitle(value = "BIC/SWIFT")
    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.revolut.revolut.test:id/account_item_container']/android.widget.EditText[@index=1]")
    private WebElement bic;

    @ElementTitle(value = "Mobile phone (optional)")
    @FindBy(id = "com.revolut.revolut.test:id/mobile_phone")
    private WebElement mobilePhone;

    @ElementTitle(value = "E-mail (optional)")
    @FindBy(id = "com.revolut.revolut.test:id/email")
    private WebElement email;

    public AccountDetailsPage() {
        initElements(getDriver(), this);
    }
}
