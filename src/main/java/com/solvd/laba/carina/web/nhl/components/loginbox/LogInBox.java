package com.solvd.laba.carina.web.nhl.components.loginbox;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogInBox extends AbstractUIObject {
    @FindBy(xpath = "//input[@name = 'email']")
    private ExtendedWebElement emailInput;
    @FindBy(xpath = "//div[contains(@class, 'error-message')]/preceding-sibling::input[@name = 'email']")
    private ExtendedWebElement emailErrorMessage;
    @FindBy(xpath = "//input[@name = 'password']")
    private ExtendedWebElement passwordInput;
    @FindBy(xpath = "//div[contains(@class, 'error-message')]/preceding-sibling::input[@name = 'password']")
    private ExtendedWebElement passwordErrorMessage;

    public LogInBox(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getEmailInput() {
        return emailInput;
    }

    public void typeEmailInput(String value){
        emailInput.type(value);
    }

    public ExtendedWebElement getPasswordInput() {
        return passwordInput;
    }
    public void typePasswordInput(String value){
        passwordInput.type(value);
    }

}
