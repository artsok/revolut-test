package com.revolut.qa.entries.transfer;

import com.revolut.qa.entries.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.exceptions.SwipeException;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;
import static ru.sbtqa.tag.pagefactory.PageFactory.getDriver;
import static ru.sbtqa.tag.pagefactory.PageFactory.initElements;

/**
 * Developed by sokovets-av
 */
@PageEntry(title = "Choose currency")
public class CurrencySelectPage extends BasePage {

    @ElementTitle(value = "Search Currency")
    @FindBy(id = "com.revolut.revolut.test:id/search_src_text")
    private WebElement currencySearch;

    public CurrencySelectPage() {
        initElements(getDriver(), this);
    }

    /**
     * Select currency with swipe down
     * @param currencyItem {@link String}
     * @throws SwipeException
     */
    void chooseCurrencyItem(String currencyItem) throws SwipeException {
        chooseItemWithSwipe(currencyItem, xpath(format("//android.widget.TextView[@text='%s']", currencyItem)));
    }

}
