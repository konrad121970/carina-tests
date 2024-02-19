package com.solvd.laba.carina.web.nhl.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InfoPageBase extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'nhl-o-pattern-title']/h2")
    private ExtendedWebElement mainHeading;

    public InfoPageBase(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getMainHeading() {
        return mainHeading;
    }

}
