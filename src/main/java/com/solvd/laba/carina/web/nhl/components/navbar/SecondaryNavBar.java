package com.solvd.laba.carina.web.nhl.components.navbar;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SecondaryNavBar extends AbstractUIObject {

    @FindBy(xpath = "./ul[contains(@class, 'nhl-c-header__menu--collapsible')]/li")
    private List<MenuItem> menuItems;
    @FindBy(xpath = ".//*[@aria-label='Shop Menu']/ul/li")
    private List<MenuItem> shopDropdownMenu;

    @FindBy(xpath = "//*[@data-js-hamburger-btn]")
    private ExtendedWebElement secondaryNavbarHamburgerMenu;

    public SecondaryNavBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public List<MenuItem> getShopDropdownMenu() {
        return shopDropdownMenu;
    }

    public ExtendedWebElement getSecondaryNavbarHamburgerMenu() {
        return secondaryNavbarHamburgerMenu;
    }

    public void clickHamburgerMenu(){
        secondaryNavbarHamburgerMenu.click();
    }
    public void hoverHamburgerMenu(){
        secondaryNavbarHamburgerMenu.hover();
    }

    public boolean isHamburgerMenuButtonPresent(){
        return secondaryNavbarHamburgerMenu.isElementPresent();
    }
}
