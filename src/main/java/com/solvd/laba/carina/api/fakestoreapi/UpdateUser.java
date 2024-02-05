package com.solvd.laba.carina.api.fakestoreapi;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.fakestore_api_url}/users/${userId}", methodType = HttpMethodType.PUT)
@ResponseTemplatePath(path = "api/fakestore/update_user_response.json")
@RequestTemplatePath(path = "api/fakestore/update_user.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class UpdateUser extends AbstractApiMethodV2 {

    public UpdateUser(Integer userId) {
        replaceUrlPlaceholder("userId", userId.toString());

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
