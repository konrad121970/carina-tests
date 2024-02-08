package com.solvd.laba.carina.web.nhl.components.footer;

import com.solvd.laba.carina.web.nhl.components.navbar.MenuItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Footer extends AbstractUIObject {

    @FindBy(xpath = ".//nav[@aria-label='Footer social']/ul/li")
    private List<MenuItem> social;
    @FindBy(xpath = ".//nav[@aria-label='Footer main']/ul/li")
    private List<MenuItem> mainItems;
    @FindBy(xpath = ".//div[@class = 'nhl-c-footer__text']")
    private ExtendedWebElement disclaimer;


    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<MenuItem> getSocial() {
        return social;
    }

    public List<MenuItem> getMainItems() {
        return mainItems;
    }

    public ExtendedWebElement getDisclaimer() {
        return disclaimer;
    }
}
