package com.solvd.laba.carina.api.fakestoreapi.controller.product;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.fakestore_api_url}/products/${productId}", methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path = "api/fakestore/product/get_single_product_response.json")
public class DeleteProduct extends AbstractApiMethodV2 {

    public DeleteProduct(Integer productId) {
        replaceUrlPlaceholder("productId", productId.toString());

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
