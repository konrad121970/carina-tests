package com.solvd.laba.carina.web.nhl.pages.android;

import com.solvd.laba.carina.web.nhl.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//*[@data-js-hamburger-btn]")
    private ExtendedWebElement secondaryNavbarHamburgerMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickHamburgerMenu(){
        secondaryNavbarHamburgerMenu.click();
    }

    public void hoverHambyrgerMenu(){
        secondaryNavbarHamburgerMenu.hover();
    }

}
