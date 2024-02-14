package com.solvd.laba.carina.web.nhl;

import com.solvd.laba.carina.web.utils.DeviceUtils;
import com.solvd.laba.carina.web.utils.MobileContextUtils;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NhlAbstractTest extends AbstractTest implements DeviceUtils {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Close']")
    private ExtendedWebElement closeWidget;

    public ExtendedWebElement getCloseWidget() {
        return closeWidget;
    }
    public void clickCloseWidget(){
        closeWidget.click();
    }

    protected void closeModalIfPresent(){
        WebDriver driver = getDriver();
        if(isDeviceMobile(driver)){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            MobileContextUtils contextHelper = new MobileContextUtils();
            contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);
            wait.until(ExpectedConditions.visibilityOf(getCloseWidget()));
            clickCloseWidget();
            contextHelper.switchMobileContext(MobileContextUtils.View.WEB_BROWSER);

            Actions actions = new Actions(driver);
            actions.scrollByAmount(0,20000);
            actions.perform();
        }
    }


}
