package com.solvd.laba.carina.web.utils;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.IDriverPool;
import com.zebrunner.carina.webdriver.device.Device;
import org.openqa.selenium.WebDriver;

public interface DeviceUtils extends IDriverPool {

    default DeviceType.Type getTypeOfDevice(WebDriver driver){
        return getDevice(driver).getDeviceType();
    }

    default boolean isDeviceDesktop(WebDriver driver){
        return getDevice(driver).getDeviceType().getType().equals("desktop");
    }

    default boolean isDeviceMobile(WebDriver driver){
        if(getDevice(driver).getDeviceType().getType().equals("android_phone")
        || getDevice(driver).getDeviceType().getType().equals("ios_phone")) {
            return true;
        } else
            return false;
    }
}