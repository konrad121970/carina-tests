package com.solvd.laba.carina.web.nhl.components.loginbox;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogInBox extends AbstractUIObject {
    @FindBy(tagName = "h1")
    private ExtendedWebElement mainHeading;
    @FindBy(tagName = "h2")
    private ExtendedWebElement secondaryHeading;
    @FindBy(xpath = "//input[@name = 'email']")
    private ExtendedWebElement emailInput;
    @FindBy(xpath = "//input[@name = 'email']/following-sibling::div")
    private ExtendedWebElement emailErrorMessage;
    @FindBy(xpath = "//input[@name = 'password']")
    private ExtendedWebElement passwordInput;
    @FindBy(xpath = "//input[@name = 'password']/following-sibling::div")
    private ExtendedWebElement passwordErrorMessage;
    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement signInButton;

    public LogInBox(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getEmailInput() {
        return emailInput;
    }

    public void typeEmailInput(String value) {
        emailInput.type(value);
    }

    public ExtendedWebElement getPasswordInput() {
        return passwordInput;
    }

    public void typePasswordInput(String value) {
        passwordInput.type(value);
    }

    public ExtendedWebElement getMainHeading() {
        return mainHeading;
    }

    public ExtendedWebElement getSecondaryHeading() {
        return secondaryHeading;
    }

    public ExtendedWebElement getEmailErrorMessage() {
        return emailErrorMessage;
    }

    public ExtendedWebElement getPasswordErrorMessage() {
        return passwordErrorMessage;
    }

    public ExtendedWebElement getSignInButton() {
        return signInButton;
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}
