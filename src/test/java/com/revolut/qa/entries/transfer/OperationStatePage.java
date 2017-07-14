package com.revolut.qa.entries.transfer;

import com.revolut.qa.entries.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.datajack.Stash;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

import java.util.stream.Stream;

import static java.lang.String.format;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.xpath;
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

    @ActionTitle("checking that beneficiary")
    public final void chooseTransferOption(String state) {
        String firstName = getValue("Legal first name");
        String lastName = getValue("Legal last name");
        String text = title.getText();
        log.info("Checked that '{}', '{}', '{}' contains in '{}'",
                firstName, lastName, state, text);
        Stream.of(firstName, lastName, state)
                .forEach(str -> assertTrue("", text.contains(str)));
    }
}
