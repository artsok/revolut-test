package com.revolut.qa.entries.auth.message;

import com.revolut.qa.entries.BasePage;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;

import static ru.sbtqa.tag.pagefactory.PageFactory.getDriver;
import static ru.sbtqa.tag.pagefactory.PageFactory.initElements;
import static ru.sbtqa.tag.pagefactory.extensions.DriverExtension.waitUntilElementPresent;

/**
 * Developed by sokovets-av
 */
@Data
public class DeleteBeneficiaryMsg extends BasePage {

    private final static String MESSAGE = "Do you really want to delete this account?";

    @ElementTitle(value = "Delete")
    @FindBy(id = "com.revolut.revolut.test:id/bt_yes")
    private WebElement delete;

    @ElementTitle(value = "Cancel")
    @FindBy(id = "com.revolut.revolut.test:id/bt_no")
    private WebElement cancel;

    @ElementTitle(value = "Message")
    @FindBy(id = "com.revolut.revolut.test:id/tv_dlg_msg")
    private WebElement dlgMsg;

    public DeleteBeneficiaryMsg() {
        initElements(getDriver(), this);
        waitUntilElementPresent(dlgMsg);
    }
}
