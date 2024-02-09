package com.solvd.laba.carina.web.nhl.components.header;

import com.solvd.laba.carina.web.nhl.components.navbar.PrimaryNavBar;
import com.solvd.laba.carina.web.nhl.components.navbar.SecondaryNavBar;
import com.solvd.laba.carina.web.nhl.pages.desktop.LogInPage;
import com.solvd.laba.carina.web.nhl.pages.desktop.SearchPage;
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
    @FindBy(xpath = "//nav[@id = 'hamburger-menu']//li[contains(@class, '-lang-switch')]")
    private LanguageButton changeLanguageButton;
    @FindBy(xpath = ".//nav[@aria-label = 'Languages']")
    private LanguageOptions languageOptions;
    @FindBy(xpath = ".//*[@aria-label = 'Sign In']")
    private ExtendedWebElement signInButton;
    @FindBy(xpath = ".//a[@aria-label = 'Search']")
    private ExtendedWebElement searchButton;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public PrimaryNavBar getPrimaryNavBar() {
        return primaryNavBar;
    }

    public SecondaryNavBar getSecondaryNavBar() {
        return secondaryNavBar;
    }

    public LanguageButton getChangeLanguageButton() {
        return changeLanguageButton;
    }

    public LanguageOptions getLanguageOptions() {
        return languageOptions;
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public ExtendedWebElement getSignInButton() {
        return signInButton;
    }

    public SearchPage clickSearchButton(){
        searchButton.click();
        return new SearchPage(getDriver());
    }

    public LogInPage clickSignInButton(){
        signInButton.click();
        return new LogInPage(driver);
    }
}
