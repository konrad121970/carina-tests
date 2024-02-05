package com.solvd.laba.carina.api.fakestoreapi.controller.user;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.fakestore_api_url}/users/${userId}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/fakestore/get_single_user.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetSingleUser extends AbstractApiMethodV2 {

    public GetSingleUser(Integer userId) {
        replaceUrlPlaceholder("userId", userId.toString());

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
