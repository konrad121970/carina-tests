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

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Close']")
    private ExtendedWebElement closeWidget;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @Override
    public void clickHamburgerMenu(){
        secondaryNavbarHamburgerMenu.click();
    }
    @Override
    public void hoverHamburgerMenu(){
        secondaryNavbarHamburgerMenu.hover();
    }

    public ExtendedWebElement getSecondaryNavbarHamburgerMenu() {
        return secondaryNavbarHamburgerMenu;
    }

    public ExtendedWebElement getCloseWidget() {
        return closeWidget;
    }

    public boolean isHamburgerMenuButtonPresent(){
        return secondaryNavbarHamburgerMenu.isElementPresent();
    }
}
