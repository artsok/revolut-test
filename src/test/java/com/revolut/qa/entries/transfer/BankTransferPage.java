package com.revolut.qa.entries.transfer;

import com.revolut.qa.entries.BasePage;
import com.revolut.qa.entries.auth.message.DeleteBeneficiaryMsg;
import com.revolut.qa.utils.entity.BeneficiaryInfo;
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
import ru.sbtqa.tag.pagefactory.exceptions.SwipeException;

import static java.util.Objects.isNull;
import static org.junit.Assert.assertFalse;
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

    @ElementTitle(value = "Menu Action Info")
    @FindBy(id = "com.revolut.revolut.test:id/menu_action_info")
    private WebElement menuActionInfo;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.revolut.revolut.test:id/item_title' and @index=0]")
    private WebElement itemTitle;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.revolut.revolut.test:id/item_subtitle1' and @index=1]")
    private WebElement itemSubtitle;

    public BankTransferPage() {
        initElements(getDriver(), this);
        waitUntilElementPresent(itemTitle);
        log.info("Opened Bank Transfer Page");
    }

    /**
     * Check that new beneficiary appear in list of beneficiaries
     */
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

    /**
     * Remove first beneficiary from list beneficiaries
     * @param confirmInfo {@link String}
     */
    @ActionTitle("delete first beneficiary in list")
    public final void deleteOperation(String confirmInfo) {
        BeneficiaryInfo beneficiary = getFirstItemInContentOfBeneficiaries();
        Stash.put("infoAboutDeleteBeneficiary", beneficiary);
        log.info("Saved to stash beneficiary: title - '{}', accNumber - '{}', sortCode - '{}'",
                beneficiary.getItemTitle(), beneficiary.getAccountNumber(), beneficiary.getSortCode());

        WebElement itemsTitle = getDriver().findElements(By.id("com.revolut.revolut.test:id/item_title")).get(0);
        pressAndMoveTo(itemsTitle);
        getDriver().findElement(By.xpath("//android.widget.Button[@text='DELETE']")).click();

        DeleteBeneficiaryMsg dbMsg = new DeleteBeneficiaryMsg();
        if(confirmInfo.equalsIgnoreCase("delete")) {
            dbMsg.getDelete().click();
            return;
        }
        dbMsg.getCancel().click();
    }

    /**
     * Check that delete operation end successfull
     * @throws SwipeException
     */
    @ActionTitle("checking that operation finished successfully")
    public final void deleteOperationSuccess() throws SwipeException {
        BeneficiaryInfo currentFirstBeneficiary = getFirstItemInContentOfBeneficiaries();
        BeneficiaryInfo infoAboutDeleteBeneficiary = getValue("infoAboutDeleteBeneficiary");
        log.info("Current info about first beneficiary title - '{}', AccNum - '{}', SC -'{}'", currentFirstBeneficiary.getItemTitle(),
                currentFirstBeneficiary.getAccountNumber(), currentFirstBeneficiary.getSortCode());
        assertFalse("Info about last delete beneficiary same as current first",
                currentFirstBeneficiary.equals(infoAboutDeleteBeneficiary));
    }

    /**
     * Check state when we cancel from delete operation
     */
    @ActionTitle("checking that beneficiary remained in list")
    public final void deleteOperationWithCancel() {
        BeneficiaryInfo currentFirstBeneficiary = getFirstItemInContentOfBeneficiaries();
        BeneficiaryInfo infoAboutDeleteBeneficiary = getValue("infoAboutDeleteBeneficiary");
        log.info("Current info about first beneficiary title - '{}', AccNum - '{}', SC -'{}'", currentFirstBeneficiary.getItemTitle(),
                currentFirstBeneficiary.getAccountNumber(), currentFirstBeneficiary.getSortCode());
        assertTrue(currentFirstBeneficiary.equals(infoAboutDeleteBeneficiary));
    }

    /**
     * Check edit operation
     */
    @ActionTitle("edit first beneficiary in list")
    public final void editOperationSuccess() {
        BeneficiaryInfo beneficiary = getFirstItemInContentOfBeneficiaries();
        Stash.put("infoAboutDeleteBeneficiary", beneficiary);
        log.info("Saved to stash beneficiary: title - '{}', accNumber - '{}', sortCode - '{}'",
                beneficiary.getItemTitle(), beneficiary.getAccountNumber(), beneficiary.getSortCode());
        WebElement itemsTitle = getDriver().findElements(By.id("com.revolut.revolut.test:id/item_title")).get(0);
        pressAndMoveTo(itemsTitle);
        getDriver().findElement(By.xpath("//android.widget.Button[@text='EDIT']")).click();
    }

    /**
     * Select first beneficiary from list of beneficiaries
     */
    @ActionTitle("selecting first beneficiary")
    public final void selectFirstBeneficiary() {
        WebElement itemsTitle = getDriver().findElements(By.id("com.revolut.revolut.test:id/item_title")).get(0);
        itemsTitle.click();
    }



    /**
     * Touch and move to the location
     * @param element {@link WebElement}
     */
    private void pressAndMoveTo(WebElement element) {
        Dimension size = element.getSize();
        Point location = element.getLocation();
        new TouchAction(PageFactory.getMobileDriver()).press(location.getX()+ size.width, location.getY())
                .waitAction(1000)
                .moveTo(location.getX(), location.getY()).release().perform();
    }



    /**
     * Get first item from list of Beneficiaries on Bank Transfer Page
     * @return {@link BeneficiaryInfo}
     */
    private BeneficiaryInfo getFirstItemInContentOfBeneficiaries() {
        WebElement itemsTitle = getDriver().findElements(By.id("com.revolut.revolut.test:id/item_title")).get(0);
        WebElement itemsAccountNumber = getDriver().findElements(By.id("com.revolut.revolut.test:id/item_subtitle1")).get(0);
        WebElement itemsSortCode = getDriver().findElements(By.id("com.revolut.revolut.test:id/item_subtitle2")).size() > 0 ?
                getDriver().findElements(By.id("com.revolut.revolut.test:id/item_subtitle2")).get(0) : null;
        if(isNull(itemsSortCode)) {
            return new BeneficiaryInfo(itemsTitle.getText(), itemsAccountNumber.getText(), "");
        }
        return new BeneficiaryInfo(itemsTitle.getText(), itemsAccountNumber.getText(), itemsSortCode.getText());
    }



}
