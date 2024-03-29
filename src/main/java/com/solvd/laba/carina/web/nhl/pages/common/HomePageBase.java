package com.solvd.laba.carina.web.nhl.pages.common;
//import  com.solvd.laba.carina.web.nhl;

import com.solvd.laba.carina.web.nhl.components.footer.Footer;
import com.solvd.laba.carina.web.nhl.components.header.Header;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public abstract class HomePageBase extends NhlAbstractPage {
    @FindBy(xpath = "//header")
    private Header header;

    @FindBy(css = ".nhl-c-headlines .nhl-o-heading")
    private ExtendedWebElement topStoriesHeading;

    @FindBy(xpath = "//footer")
    private Footer footer;

    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    private ExtendedWebElement acceptCookies;

    public HomePageBase(WebDriver driver) {
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

    @Override
    public void open() {
        super.open();
        while (!acceptCookies.isClickable()) {
        }
        acceptCookies.click();
    }


}
