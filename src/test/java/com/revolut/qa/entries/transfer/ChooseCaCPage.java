package com.revolut.qa.entries.transfer;

import com.revolut.qa.entries.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.exceptions.SwipeException;

import static ru.sbtqa.tag.pagefactory.PageFactory.getDriver;
import static ru.sbtqa.tag.pagefactory.PageFactory.initElements;

/**
 * Developed by sokovets-av
 */
@Slf4j
@PageEntry(title = "Choose country and currency")
public class ChooseCaCPage extends BasePage {

    @ElementTitle(value = "Country")
    @FindBy(id = "com.revolut.revolut.test:id/edit_country")
    private WebElement country;

    @ElementTitle(value = "Currency")
    @FindBy(id = "com.revolut.revolut.test:id/edit_currency")
    private WebElement currency;

    public ChooseCaCPage() {
        initElements(getDriver(), this);
    }

    @ActionTitle("choosing country")
    public final void chooseCountry(String countryItem) throws SwipeException {
        clickWebElement(country);
        CountrySelectPage csp = new CountrySelectPage();
        csp.chooseCountryItem(countryItem);
        log.info("Choosed country '{}", countryItem);
    }


    @ActionTitle("choosing currency")
    public final void chooseCurrency(String currencyItem) throws SwipeException {
        clickWebElement(currency);
        CurrencySelectPage csp = new CurrencySelectPage();
        csp.chooseCurrencyItem(currencyItem);
        log.info("Choosed currency '{}", currencyItem);
    }
}
