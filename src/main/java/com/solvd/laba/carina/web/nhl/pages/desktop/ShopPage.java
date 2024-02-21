package com.solvd.laba.carina.web.nhl.pages.desktop;

import com.solvd.laba.carina.web.nhl.pages.common.ShopPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ShopPageBase.class)
public class ShopPage extends ShopPageBase {
    public ShopPage(WebDriver driver) {
        super(driver);
    }
}
