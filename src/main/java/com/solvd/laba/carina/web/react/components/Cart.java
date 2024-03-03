package com.solvd.laba.carina.web.react.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Cart extends AbstractUIObject {

    @FindBy(xpath = ".//div[contains(@class, 'sc-11uohgb-0')]")
    private List<CartProductCard> cartProductCardList;


    public Cart(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<CartProductCard> getCartProductCardList() {
        return cartProductCardList;
    }
}
