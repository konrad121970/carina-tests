package com.solvd.laba.carina.web.nhl.pages.android;

import com.solvd.laba.carina.web.nhl.pages.common.ShopPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ShopPageBase.class)
public class ShopPage extends ShopPageBase {
    public ShopPage(WebDriver driver) {
        super(driver);
    }
}
