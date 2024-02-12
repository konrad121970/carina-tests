package com.solvd.laba.carina.web.nhl.components.header;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LanguageButton extends AbstractUIObject {

    @FindBy(xpath = "./button/span[2]")
    private ExtendedWebElement text;

    public LanguageButton(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getButton() {
        return text;
    }

    public String getTextValue() {
        return text.getText();
    }

    public void clickLanguageButton(){
        text.click();
    }

    public boolean isLanguageButtonClickable(){
        return text.isClickable();
    }

    public boolean isLanguageButtonPresent(){
        return text.isPresent();
    }

}
