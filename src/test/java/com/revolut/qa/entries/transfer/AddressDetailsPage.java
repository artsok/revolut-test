package com.revolut.qa.entries.transfer;

import com.revolut.qa.entries.BasePage;
import cucumber.api.DataTable;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.datajack.Stash;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.pagefactory.exceptions.SwipeException;

import static java.lang.String.format;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.xpath;
import static ru.sbtqa.tag.pagefactory.PageFactory.getDriver;
import static ru.sbtqa.tag.pagefactory.PageFactory.initElements;

/**
 * Developed by sokovets-av
 */
@Slf4j
@PageEntry(title = "Address details")
public class AddressDetailsPage extends BasePage {

    @ElementTitle(value = "Country")
    @FindBy(id = "com.revolut.revolut.test:id/address_edit_country")
    private WebElement country;

    @ElementTitle(value = "Postal Code")
    @FindBy(id = "com.revolut.revolut.test:id/address_postal_code")
    private WebElement postalCode;

    @ElementTitle(value = "Search")
    @FindBy(id = "com.revolut.revolut.test:id/search_icon")
    private WebElement search;

    @ElementTitle(value = "Main Address")
    @FindBy(id = "com.revolut.revolut.test:id/address_line_1")
    private WebElement mainAddress;

    @ElementTitle(value = "Second Address")
    @FindBy(id = "com.revolut.revolut.test:id/address_line_2")
    private WebElement secondAddress;

    @ElementTitle(value = "City")
    @FindBy(id = "com.revolut.revolut.test:id/address_city")
    private WebElement city;

    @ElementTitle(value = "Address Region")
    @FindBy(id = "com.revolut.revolut.test:id/address_region")
    private WebElement addressRegion;

    public AddressDetailsPage() {
        initElements(getDriver(), this);
    }

    @ActionTitle("checking that autocomplete work")
    public final void checkAutocomplete(DataTable dataTable) {
        dataTable.asList(String.class).forEach(element -> {
            try {
                String value = getElementByTitle(element).getText();
                assertTrue("Field are empty. Element '" + element + "'. ", !value.isEmpty());
            } catch (PageException e) {
                log.error("Error at check autocomplete at Address Details Page", e);
            }
        });
    }

    @ActionTitle("finding country")
    public final void findCountry(String countryItem) throws SwipeException {
        country.click();
        final String element = "//android.widget.EditText[@resource-id='com.revolut.revolut.test:id/search_src_text']";
        getDriver().findElement(By.xpath(element)).sendKeys(countryItem);
        chooseItemWithSwipe(countryItem, xpath(format("//android.widget.TextView[@text='%s']", countryItem)));
        log.info("finded country '{}", countryItem);
    }
}
