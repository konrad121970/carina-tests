package com.solvd.laba.carina.web.nhl.components.header;

import com.solvd.laba.carina.web.nhl.components.navbar.MenuItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LanguageOptions extends AbstractUIObject {

    @FindBy(xpath = "./ul/li")
    private List<MenuItem> languageOptions;

    public LanguageOptions(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<MenuItem> getLanguageOptions() {
        return languageOptions;
    }
}
