package com.solvd.laba.carina.web.nhl.pages;

import com.solvd.laba.carina.web.nhl.components.searchbar.SearchBar;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class StatsPage extends AbstractPage {

    @FindBy(xpath = "//h1")
    private ExtendedWebElement mainHeading;


    public StatsPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getMainHeading() {
        return mainHeading;
    }

    public String getMainHeadingText(){
        return mainHeading.getText();
    }
}
