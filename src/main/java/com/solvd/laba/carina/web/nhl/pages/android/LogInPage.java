package com.solvd.laba.carina.web.nhl.pages.android;

import com.solvd.laba.carina.web.nhl.components.loginbox.LogInBox;
import com.solvd.laba.carina.web.nhl.pages.common.HomePageBase;
import com.solvd.laba.carina.web.nhl.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
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
