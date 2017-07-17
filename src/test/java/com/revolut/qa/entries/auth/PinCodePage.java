package com.revolut.qa.entries.auth;

import com.revolut.qa.entries.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

import static ru.sbtqa.tag.pagefactory.PageFactory.getDriver;
import static ru.sbtqa.tag.pagefactory.PageFactory.initElements;

/**
 * Developed by sokovets-av
 */
@Slf4j
@PageEntry(title = "PinCode Page")
public class PinCodePage extends BasePage {

    public PinCodePage() {
        initElements(getDriver(), this);
        log.info("Opened PinCode Page");
    }

    /**
     * Fill pass code
     * @param passCode {@link String}
     */
    @ActionTitle("entering passcode")
    public void enterPin(final String passCode)  {
        char[] charArray = passCode.toCharArray();
        for (char pin : charArray) {
            final String element = "//android.widget.TextView[@text='" + pin + "']";
            clickWebElement(getDriver().findElement(By.xpath(element)));
        }
    }

}
