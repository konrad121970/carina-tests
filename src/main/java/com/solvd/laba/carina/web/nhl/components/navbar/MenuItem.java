package com.solvd.laba.carina.web.nhl.components.navbar;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MenuItem extends AbstractUIObject {

    @FindBy(xpath = "./a")
    private ExtendedWebElement text;

    public MenuItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getText() {
        return text.getText();
    }

    public <T extends AbstractUIObject> T clickMenuItem(Class<T> pageClass){
        text.click();
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException("Error creating page instance", e);
        }
    }
}
