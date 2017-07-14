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
@PageEntry(title = "Choose transfer type")
public class ChooseTransferTypePage extends BasePage {

    @ElementTitle(value = "To myself")
    @FindBy(xpath = "//android.widget.TextView[@text='To myself']")
    private WebElement mySelf;

    @ElementTitle(value = "To another person")
    @FindBy(xpath = "//android.widget.TextView[@text='To another person']")
    private WebElement anotherPerson;

    @ElementTitle(value = "To a business")
    @FindBy(xpath = "//android.widget.TextView[@text='To a business']")
    private WebElement business;

    public ChooseTransferTypePage() {
        initElements(getDriver(), this);
    }
}
