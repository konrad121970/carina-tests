package com.solvd.laba.carina.web.nhl.components.searchresult;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchResult extends AbstractUIObject {
    @FindBy(xpath = ".//h2")
    private ExtendedWebElement heading;

    @FindBy(xpath = ".//div[@class = 'fa-text__body']")
    private ExtendedWebElement description;

    public SearchResult(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getHeading() {
        return heading;
    }

    public ExtendedWebElement getDescription() {
        return description;
    }
}
