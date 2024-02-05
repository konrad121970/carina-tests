package com.solvd.laba.carina.api.fakestoreapi;

import com.solvd.laba.carina.api.fakestoreapi.controller.product.AddNewProduct;
import com.solvd.laba.carina.api.fakestoreapi.controller.product.GetSingleProduct;
import com.solvd.laba.carina.api.fakestoreapi.domain.product.Product;
import com.zebrunner.agent.core.registrar.domain.ObjectMapperImpl;
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

        product = objectMapper.readValue(response, Product.class);

        getSingleProduct.validateResponse();
    }

    @Test
    public void addNewProduct(){
        AddNewProduct addNewProduct = new AddNewProduct();

        Product product = new Product();
        product.setTitle("Alleluja");
        product.setCategory("Games");
        product.setImage("https://alasdl.com");
        product.setPrice(12.0);
        product.setDescription("lalalal");

        addNewProduct.addProperty("product", product);
        addNewProduct.callAPI();

        addNewProduct.validateResponse();
    }

}
