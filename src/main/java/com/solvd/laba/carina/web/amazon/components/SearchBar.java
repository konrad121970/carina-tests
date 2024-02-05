package com.solvd.laba.carina.web.amazon.components;

import com.solvd.laba.carina.web.amazon.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchBar extends AbstractUIObject {

    @FindBy(xpath = ".//*[@id = 'nav-search-dropdown-card']")
    private ExtendedWebElement productTypesSelect;

    @FindBy(xpath = ".//input[@id = 'twotabsearchtextbox']")
    private ExtendedWebElement textInput;

    @FindBy(xpath = ".//*[@id = 'nav-search-submit-button']")
    private ExtendedWebElement searchButton;
    public SearchBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getProductTypesSelect() {
        return productTypesSelect;
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

    public void typeSearcInputValue(String value){
        textInput.type(value);
    }

    public SearchPage clickSearchButton(){
        searchButton.click();
        return new SearchPage(getDriver());
    }

}
