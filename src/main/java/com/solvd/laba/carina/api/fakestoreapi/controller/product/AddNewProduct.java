package com.solvd.laba.carina.api.fakestoreapi.controller.product;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.fakestore_api_url}/products", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/fakestore/product/add_new_product_request.json")
@ResponseTemplatePath(path = "api/fakestore/product/add_new_product_response.json")
public class AddNewProduct extends AbstractApiMethodV2 {

    public AddNewProduct() {
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
