package com.solvd.laba.carina.web.nhl.pages.android;

import com.solvd.laba.carina.web.nhl.pages.common.InfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = InfoPageBase.class)
public class InfoPage extends InfoPageBase {


    public InfoPage(WebDriver driver) {
        super(driver);
    }


}
