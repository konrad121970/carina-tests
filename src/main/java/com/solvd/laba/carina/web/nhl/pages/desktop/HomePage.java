package com.solvd.laba.carina.web.nhl.pages.desktop;

import com.solvd.laba.carina.web.nhl.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickHamburgerMenu() {

    }
}
