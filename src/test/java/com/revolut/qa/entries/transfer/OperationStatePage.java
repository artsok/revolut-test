package com.revolut.qa.entries.transfer;

import com.revolut.qa.entries.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;
import static ru.sbtqa.tag.datajack.Stash.getValue;
import static ru.sbtqa.tag.pagefactory.PageFactory.getDriver;
import static ru.sbtqa.tag.pagefactory.PageFactory.initElements;
import static ru.sbtqa.tag.pagefactory.extensions.DriverExtension.waitUntilElementPresent;

/**
 * Developed by sokovets-av
 */
@Slf4j
@PageEntry(title = "Operation State")
public class OperationStatePage extends BasePage {

    @ElementTitle(value = "Operation title")
    @FindBy(id = "com.revolut.revolut.test:id/operation_state_title")
    private WebElement title;

    public OperationStatePage() {
        initElements(getDriver(), this);
        waitUntilElementPresent(title);
    }

    /**
     * Check operation state
     * @param state {@link String}
     */
    @ActionTitle("checking that beneficiary")
    public final void checkingStatusOfOperation(String state) {
        String firstName = getValue("Legal first name");
        String lastName = getValue("Legal last name");
        String text = title.getText();
        log.info("Checked that '{}', '{}', '{}' contains in '{}'",
                firstName, lastName, state, text);
        Stream.of(firstName, lastName, state)
                .forEach(str -> assertTrue("assertion failed", text.contains(str)));
    }

    /**
     * Check that beneficiary successfull change
     */
    @ActionTitle("checking that beneficiary successfully changed")
    public final void checkingChangedOperation() {
        String text = title.getText();
        assertTrue("assertion failed", text.contains("successfully changed"));
    }

    /**
     * Check that transfer done
     */
    @ActionTitle("checking that transfer is successfull")
    public final void checkingTransferOperation() {
        String text = title.getText();
        assertTrue("assertion failed", text.contains("Your transfer is on its way!"));
    }

}
