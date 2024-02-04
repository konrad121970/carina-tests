package com.solvd.laba.carina.api.fakestoreapi;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.fakestore_api_url}/products/${productId}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/fakestore/get_single_product.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetSingleProduct extends AbstractApiMethodV2 {

    public GetSingleProduct(int productId) {
        replaceUrlPlaceholder("productId", String.valueOf(productId));

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
