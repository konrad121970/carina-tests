package com.solvd.laba.carina.api.fakestoreapi;

import com.solvd.laba.carina.api.fakestoreapi.domain.Product;
import org.testng.annotations.Test;

public class ProductTest {

    @Test
    public void verifyGetSingleProductByProductId() {

        Product product = new Product();
        product.setId(1);

        GetSingleProduct getSingleProduct = new GetSingleProduct(product.getId());
        getSingleProduct.addProperty("product", product);

        getSingleProduct.callAPI();

        getSingleProduct.validateResponse();
    }
}
