package com.solvd.laba.carina.api.fakestoreapi.controller.product;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.fakestore_api_url}/products/${productId}", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/fakestore/product/add_new_product_request.json")
@ResponseTemplatePath(path = "api/fakestore/product/update_product_response.json")
public class UpdateProduct extends AbstractApiMethodV2 {

    public UpdateProduct(Integer productId) {
        replaceUrlPlaceholder("productId", productId.toString());

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
