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


    public SecondaryNavBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
