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
@PageEntry(title = "Choose country")
public class CountrySelectPage extends BasePage {

    @ElementTitle(value = "Search Country")
    @FindBy(id = "com.revolut.revolut.test:id/search_src_text")
    private WebElement countrySearch;

    public CountrySelectPage() {
        initElements(getDriver(), this);
    }


    void chooseCountryItem(String countryItem) throws SwipeException {
        chooseItemWithSwipe(countryItem, xpath(format("//android.widget.TextView[@text='%s']", countryItem)));
    }

}
