package com.solvd.laba.carina.web.nhl.pages.desktop;

import com.solvd.laba.carina.web.nhl.components.loginbox.LogInBox;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends AbstractPage {

    @FindBy(className = "login-form")
    private LogInBox logInBox;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public LogInBox getLogInBox() {
        return logInBox;
    }
}
