package com.revolut.qa.entries.auth;

import com.revolut.qa.entries.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

import static ru.sbtqa.tag.pagefactory.PageFactory.getDriver;
import static ru.sbtqa.tag.pagefactory.PageFactory.initElements;

/**
 * Developed by sokovets-av
 */
@Slf4j
@PageEntry(title = "Authorization Page")
public class AuthorizationPage extends BasePage {

    @ElementTitle(value = "CountryCode")
    @FindBy(id = "com.revolut.revolut.test:id/uic_edit_country_code")
    private WebElement countyCode;

    @ElementTitle(value = "PhoneNumber")
    @FindBy(id = "com.revolut.revolut.test:id/uic_edit_phone_number")
    private WebElement phoneaaaNumber;

    @ElementTitle(value = "Agreement")
    @FindBy(id = "com.revolut.revolut.test:id/button_agreement")
    private WebElement versionTxt;

    
    public AuthorizationPage() {
        initElements(getDriver(), this);
        log.info("Opened Authorization Page");
    }
}
