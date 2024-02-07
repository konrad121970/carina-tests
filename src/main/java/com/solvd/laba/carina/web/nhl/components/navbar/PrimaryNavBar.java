package com.solvd.laba.carina.web.nhl.components.navbar;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PrimaryNavBar extends AbstractUIObject {

    @FindBy(xpath = "./ul/li")
    private List<MenuItem> menuItems;

    public PrimaryNavBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
