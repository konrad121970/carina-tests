package com.solvd.laba.carina.api.fakestoreapi;

import com.solvd.laba.carina.api.fakestoreapi.domain.Product;
import com.zebrunner.agent.core.registrar.domain.ObjectMapperImpl;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import kong.unirest.ObjectMapper;
import org.testng.annotations.Test;

public class ProductTest {

    @Test
    public void verifyGetSingleProductByProductId() {

        Product product = new Product();
        product.setId(1);
        //product.setPrice(120.00);

        GetSingleProduct getSingleProduct = new GetSingleProduct(product.getId());
        getSingleProduct.addProperty("product", product);

        //getSingleProduct.expectResponseStatus(HttpResponseStatusType.OK_200);
        String response = getSingleProduct.callAPIExpectSuccess().asString();
        ObjectMapper objectMapper = new ObjectMapperImpl();

        Product product1 = objectMapper.readValue(response, Product.class);

        getSingleProduct.validateResponse();

    }
}
