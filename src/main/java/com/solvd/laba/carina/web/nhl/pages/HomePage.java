package com.solvd.laba.carina.web.nhl.pages;

import com.solvd.laba.carina.web.nhl.components.footer.Footer;
import com.solvd.laba.carina.web.nhl.components.header.Header;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//header")
    private Header header;

    @FindBy(css = ".nhl-c-headlines .nhl-o-heading")
    private ExtendedWebElement topStoriesHeading;

    @FindBy(xpath = "//footer")
    private Footer footer;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("nhl_url"));
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    public ExtendedWebElement getTopStoriesHeading() {
        return topStoriesHeading;
    }
}
