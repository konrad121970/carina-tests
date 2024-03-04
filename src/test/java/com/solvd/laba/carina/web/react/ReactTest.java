package com.solvd.laba.carina.web.react;


import com.solvd.laba.carina.web.react.components.Cart;
import com.solvd.laba.carina.web.react.components.CartProductCard;
import com.solvd.laba.carina.web.react.components.ProductCard;
import com.solvd.laba.carina.web.react.pages.HomePage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ReactTest extends AbstractTest {


    @Test
    public void testHomePage() {
        HomePage page = new HomePage(getDriver());
        page.open();

        List<ProductCard> productCardList = page.getProductCardList();


        productCardList.get(0).clickAddToCartButton();
        String firstTitle = productCardList.get(0).getTitle();
        productCardList.get(1).clickAddToCartButton();

        System.out.println();

        Cart cart = page.getCart();
        List<CartProductCard> cartList = cart.getCartProductCardList();

        assertTrue(cartList.size() == 2, "Cart should have 2 products inside");

        System.out.println();

        String secondTitle = cartList.get(1).getTitle();

        assertEquals(firstTitle, secondTitle, "The product titles should match each other");
        assertEquals(firstTitle, secondTitle, "The product titles should match each other");


        productCardList.get(2).getTitleText();

        System.out.println();


    }


}
