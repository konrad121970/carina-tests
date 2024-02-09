package com.solvd.laba.carina.web.nhl.pages.desktop;

import com.solvd.laba.carina.web.nhl.components.searchbar.SearchBar;
import com.solvd.laba.carina.web.nhl.components.searchresult.SearchResult;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//*[@class = 'nhl-o-pattern-title']//h2")
    private ExtendedWebElement mainHeading;

    @FindBy(xpath = "//label[@for = 'input-search-query']/..")
    private SearchBar searchBar;

    @FindBy(xpath = "//*[contains(@class, 'oc-card--boxed-horizontal-100')]")
    private List<SearchResult> searchResult;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getMainHeading() {
        return mainHeading;
    }

    public SearchBar getSearchBar() {
        return searchBar;
    }

    public List<SearchResult> getSearchResult() {
        return searchResult;
    }
}
