package com.solvd.laba.carina.web.nhl.pages.android;

import com.solvd.laba.carina.web.nhl.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {
    public ProductPage(WebDriver driver) {
        super(driver);
    }
}
