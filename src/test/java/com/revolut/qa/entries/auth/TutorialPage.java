package com.revolut.qa.entries.auth;

import com.revolut.qa.entries.BasePage;
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
@PageEntry(title = "Tutorial Page")
public class TutorialPage extends BasePage {

    @ElementTitle(value = "Continue")
    @FindBy(id = "com.revolut.revolut.test:id/next_button")
    private WebElement continueBtn;

    public TutorialPage() {
        initElements(getDriver(), this);
        waitUntilElementPresent(continueBtn);
        log.info("Openeded Tutorial Page");
    }

    @ActionTitle("introducing with tutorial")
    public final void verifyCreatedChecklist()  {
        String next = "//android.widget.Button[@text='Continue']";
        String gotIt = "//android.widget.Button[@text='Got it']";
        for (int i = 0; i < 4; i++) {
            clickWebElement(getDriver().findElement(By.xpath(next)));
        }
        clickWebElement(getDriver().findElement(By.xpath(gotIt)));
    }


}
