package com.solvd.laba.carina.web.nhl.pages.common;

import com.solvd.laba.carina.web.utils.DeviceUtils;
import com.solvd.laba.carina.web.utils.MobileContextUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NhlAbstractPage extends AbstractPage implements DeviceUtils {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Close']")
    private ExtendedWebElement closeWidget;

    public NhlAbstractPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getCloseWidget() {
        return closeWidget;
    }

    public void clickCloseWidget() {
        closeWidget.click();
    }

    public void closeModalIfPresent() {
        if (isDeviceMobile(driver)) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            MobileContextUtils contextHelper = new MobileContextUtils();
            contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);

            wait.until(ExpectedConditions.visibilityOf(closeWidget));
            clickCloseWidget();
            contextHelper.switchMobileContext(MobileContextUtils.View.WEB_BROWSER);

            Actions actions = new Actions(driver);
            actions.scrollByAmount(0, 20000);
            actions.perform();
        }
    }


}
