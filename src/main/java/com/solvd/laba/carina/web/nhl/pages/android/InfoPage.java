package com.solvd.laba.carina.web.nhl.pages.android;

import com.solvd.laba.carina.web.nhl.pages.common.HomePageBase;
import com.solvd.laba.carina.web.nhl.pages.common.InfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = InfoPageBase.class)
public class InfoPage extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'nhl-o-pattern-title']/h2")
    private ExtendedWebElement mainHeading;

    public InfoPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getMainHeading() {
        return mainHeading;
    }
}
