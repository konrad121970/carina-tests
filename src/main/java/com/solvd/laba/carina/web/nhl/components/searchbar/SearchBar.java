package com.solvd.laba.carina.web.nhl.components.searchbar;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchBar extends AbstractUIObject {

    @FindBy(id = "input-search-query")
    private ExtendedWebElement textInput;

    @FindBy(id = "search__btn")
    private ExtendedWebElement searchButton;

    public SearchBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void inputSearchQuery(String value){
        textInput.type(value);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public ExtendedWebElement getTextInput() {
        return textInput;
    }

    public String getTextInputPlaceholder(){
        return textInput.getAttribute("placeholder");
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }
}
