package com.revolut.qa.entries.transfer;

import com.revolut.qa.entries.BasePage;
import io.appium.java_client.TouchAction;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.datajack.Stash;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static ru.sbtqa.tag.datajack.Stash.getValue;
import static ru.sbtqa.tag.pagefactory.PageFactory.getDriver;
import static ru.sbtqa.tag.pagefactory.PageFactory.initElements;
import static ru.sbtqa.tag.pagefactory.extensions.DriverExtension.waitUntilElementPresent;

/**
 * Developed by sokovets-av
 */
@Slf4j
@PageEntry(title = "Bank Transfer")
public class BankTransferPage extends BasePage {

    @ElementTitle(value = "Add a new beneficiary")
    @FindBy(id = "com.revolut.revolut.test:id/list_add_new_item_text")
    private WebElement addNewBeneficiary;

    @ElementTitle(value = "Edit beneficiary")
    @FindBy(id = "com.revolut.revolut.test:id/edit_beneficiary")
    private WebElement edit;

    @ElementTitle(value = "Delete beneficiary")
    @FindBy(id = "com.revolut.revolut.test:id/delete_beneficiary")
    private WebElement delete;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.revolut.revolut.test:id/item_title' and @index=0]")
    private WebElement itemTitle;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.revolut.revolut.test:id/item_subtitle1' and @index=1]")
    private WebElement itemSubtitle;


    public BankTransferPage() {
        initElements(getDriver(), this);
        waitUntilElementPresent(itemTitle);
    }

    @ActionTitle("checking that new beneficiary appear in list of beneficiaries")
    public final void newBeneficiaryCreated() {
        String firstName = getValue("Legal first name");
        String lastName = getValue("Legal last name");
        String iban = getValue("IBAN/Account number");

        log.info("firstName - '{}', lastname - '{}', iban - {}' ", firstName, lastName, iban);
        log.info("Text of title '{}', '{}'", itemTitle.getText(), itemSubtitle.getText());

        assertTrue("Invalid info (Name) for beneficiarie", itemTitle.getText().contains(firstName));
        assertTrue("Invalid info (Last Name) for beneficiarie", itemTitle.getText().contains(lastName));
        assertTrue("Invalid info (IBAN) for beneficiarie",
                itemSubtitle.getText().contains(iban.replaceAll("\\s", "")));
        log.info("Checked - new beneficiary appeared in list of beneficiaries");
    }

    //TODO: Swipe left don't work
    @ActionTitle("delete first beneficiary in list")
    public final void delete() {
        List<WebElement> list = getDriver().findElements(By.id("com.revolut.revolut.test:id/item_title"));
        Stash.put("firstBeneficiary", list.get(0).getText());

        Dimension size = list.get(0).getSize();
        Point location = list.get(0).getLocation();
        new TouchAction(PageFactory.getMobileDriver()).press(location.getX()+ size.width - 50,
                location.getY()).moveTo(list.get(0), location.getX()+ size.width - 20, location.getY()).perform();


    }

}
