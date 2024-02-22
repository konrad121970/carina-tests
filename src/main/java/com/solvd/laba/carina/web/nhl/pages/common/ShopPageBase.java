package com.solvd.laba.carina.web.nhl.pages.common;

import com.solvd.laba.carina.web.nhl.components.ProductCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopPageBase extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'product-card row']")
    private List<ProductCard> productCards;

    @FindBy(xpath = "//*[@aria-label = 'Close Pop-Up']")
    private ExtendedWebElement closePopup;

    public ShopPageBase(WebDriver driver) {
        super(driver);
    }

    public ProductCard selectRandomProductCard() {
        int randomNum = (int) (Math.random() * (productCards.size() + 1));
        return productCards.get(randomNum);
    }

    public List<ProductCard> getProductCards() {
        return productCards;
    }

    public boolean isPopupPresent() {
        return closePopup.isElementPresent();
    }

    public void clickClosePopup() {
        closePopup.click();
    }

}
