package com.solvd.laba.carina.web.react.pages;

import com.solvd.laba.carina.web.react.components.Cart;
import com.solvd.laba.carina.web.react.components.ProductCard;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'sc-124al1g-2')]")
    private List<ProductCard> productCardList;

    @FindBy(xpath = "//div[contains(@class, 'sc-1h98xa9-1 kQlqIC')]")
    private Cart cart;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("react_url"));
    }

    public List<ProductCard> getProductCardList() {
        return productCardList;
    }

    public Cart getCart() {
        return cart;
    }

}
