package com.solvd.laba.carina.web.nhl.components.navbar;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class MenuItem extends AbstractUIObject {

    @FindAll({
            @FindBy(xpath = "./a"),
            @FindBy(xpath = "./button")
    })
    private ExtendedWebElement text;

    public MenuItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTextValue() {
        return text.getText();
    }

    public ExtendedWebElement getTextElement(){
        return text;
    }

    public <T extends AbstractPage> T clickMenuItemAndReturnNewPage(Class<T> pageClass){
        text.click();
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException("Error creating page instance", e);
        }
    }

    public void clickMenuItem(){
        text.click();
    }
}
