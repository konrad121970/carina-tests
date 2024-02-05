package com.solvd.laba.carina.api.fakestoreapi;

import com.solvd.laba.carina.api.fakestoreapi.controller.product.AddNewProduct;
import com.solvd.laba.carina.api.fakestoreapi.controller.product.DeleteProduct;
import com.solvd.laba.carina.api.fakestoreapi.controller.product.GetSingleProduct;
import com.solvd.laba.carina.api.fakestoreapi.controller.product.UpdateProduct;
import com.solvd.laba.carina.api.fakestoreapi.domain.product.Product;
import com.zebrunner.agent.core.registrar.domain.ObjectMapperImpl;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.registrar.tag.TestTag;
import kong.unirest.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductTest {

    @Test(dataProvider = "DP3")
    public void verifyGetSingleProductByProductId(Integer id) {

        Product product = new Product();
        product.setId(id);
        //product.setPrice(120.00);

        GetSingleProduct getSingleProduct = new GetSingleProduct(product.getId());
        getSingleProduct.addProperty("product", product);

        //getSingleProduct.expectResponseStatus(HttpResponseStatusType.OK_200);
        String response = getSingleProduct.callAPIExpectSuccess().asString();
        ObjectMapper objectMapper = new ObjectMapperImpl();

        product = objectMapper.readValue(response, Product.class);

        getSingleProduct.validateResponse();
    }

    @Test(dataProvider = "DP2")
    public void addNewProduct(String title, String category, String image, Double price, String description){
        AddNewProduct addNewProduct = new AddNewProduct();

        Product product = new Product();
        product.setTitle(title);
        product.setCategory(category);
        product.setImage(image);
        product.setPrice(price);
        product.setDescription(description);

        addNewProduct.addProperty("product", product);
        addNewProduct.callAPI();

        addNewProduct.validateResponse();
    }


    @Test(dataProvider = "DP1")
    public void updateProduct(Integer id, String title, String category, String image, Double price, String description){
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setCategory(category);
        product.setImage(image);
        product.setPrice(price);
        product.setDescription(description);

        UpdateProduct updateProduct = new UpdateProduct(product.getId());
        updateProduct.addProperty("product", product);
        updateProduct.callAPI();

        updateProduct.validateResponse();
    }

    @Test(dataProvider = "DP3")
    public void deleteProduct(Integer productId){
        Product product = new Product();
        product.setId(productId);

        DeleteProduct deleteProduct = new DeleteProduct(product.getId());
        deleteProduct.addProperty("product", product);
        deleteProduct.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteProduct.callAPI();

        deleteProduct.validateResponse();
    }

    @DataProvider(name = "DP1")
    public Object[][] provideProducts(){
        return new Object[][] {
                {2, "Product1", "Electronics", "https://alasdl.com", 15.0, "LOrem"},
                {5, "Product2", "Karamba", "https://alasdl.com", 129.0, "LOrem ipsum"},
                {8, "Product3", "Clothing", "https://example.com", 49.99, "Description 3"},
                {11, "Product4", "Books", "https://example.com", 29.99, "Description 4"}
        };
    }

    @DataProvider(name = "DP2")
    public Object[][] provideProductsWithoutIds(){
        return new Object[][] {
                {"Product1", "Electronics", "https://alasdl.com", 15.0, "LOrem"},
                {"Product2", "Karamba", "https://alasdl.com", 129.0, "LOrem ipsum"},
                {"Product3", "Clothing", "https://example.com", 49.99, "Description 3"},
                {"Product4", "Books", "https://example.com", 29.99, "Description 4"}
        };
    }

    @DataProvider(name = "DP3")
    public Object[][] provideProductIds(){
        return new Object[][] {
                {1}, // 2
                {2}, // 5
                {15}, // 8
                {3} // 11
        };
    }

}
