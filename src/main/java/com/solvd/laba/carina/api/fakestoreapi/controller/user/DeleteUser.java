package com.solvd.laba.carina.api.fakestoreapi.controller.user;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.fakestore_api_url}/users/${userId}", methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path = "api/fakestore/user/get_single_user_response.json")
public class DeleteUser extends AbstractApiMethodV2 {

    public DeleteUser(Integer userId) {
        replaceUrlPlaceholder("userId", userId.toString());

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
