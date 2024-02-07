package com.solvd.laba.carina.web.nhl.components.header;

import com.solvd.laba.carina.web.nhl.components.navbar.PrimaryNavBar;
import com.solvd.laba.carina.web.nhl.components.navbar.SecondaryNavBar;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = ".//nav[contains(@aria-label, 'Main')]")
    private PrimaryNavBar primaryNavBar;

    @FindBy(xpath = ".//nav[@aria-label = 'Navigation Menu']")
    private SecondaryNavBar secondaryNavBar;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
