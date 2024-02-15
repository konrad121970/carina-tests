package com.solvd.laba.carina.web.nhl.components.header;

import com.solvd.laba.carina.web.nhl.components.navbar.MenuItem;
import com.solvd.laba.carina.web.nhl.components.navbar.PrimaryNavBar;
import com.solvd.laba.carina.web.nhl.components.navbar.SecondaryNavBar;
import com.solvd.laba.carina.web.nhl.enums.MenuOptions;
import com.solvd.laba.carina.web.nhl.pages.desktop.LogInPage;
import com.solvd.laba.carina.web.nhl.pages.desktop.SearchPage;
import com.solvd.laba.carina.web.utils.DeviceUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Header extends AbstractUIObject implements DeviceUtils {

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

    public void clickMenuItem(MenuOptions option) {
        if (option.getNavbarNumber() == 1) {
            primaryNavBar.getMenuItems().stream().filter(menuItem -> menuItem.getTextValue().equals(option.getName())).findFirst().get().click();
        } else if (isDeviceDesktop(driver)) {
            secondaryNavBar.getMenuItems().stream().filter(menuItem -> menuItem.getTextValue().equals(option.getName())).findFirst().get().click();
        } else {
            secondaryNavBar.clickHamburgerMenu();
            secondaryNavBar.getMenuItems().stream().filter(menuItem -> menuItem.getTextValue().equals(option.getName())).findFirst().get().click();
        }
    }


    public PrimaryNavBar getPrimaryNavBar() {
        return primaryNavBar;
    }

    public SecondaryNavBar getSecondaryNavBar() {
        return secondaryNavBar;
    }

    public List<MenuItem> getLanguageOptionsList() {
        return languageOptions.getLanguageOptionsList();
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return new SearchPage(getDriver());
    }

    public boolean isSearchButtonPresent() {
        return searchButton.isElementPresent();
    }

    public LogInPage clickSignInButton() {
        signInButton.click();
        return new LogInPage(driver);
    }

    public boolean isSignInButtonPresent() {
        return signInButton.isElementPresent();
    }

    public void hoverSignInButton() {
        signInButton.hover();
    }

    public boolean isLanguageButtonClickable() {
        return changeLanguageButton.isLanguageButtonClickable();
    }

    public boolean isLanguageButtonPresent() {
        return changeLanguageButton.isLanguageButtonPresent();
    }

    public void clickLanguageButton() {
        changeLanguageButton.clickLanguageButton();
    }


}
