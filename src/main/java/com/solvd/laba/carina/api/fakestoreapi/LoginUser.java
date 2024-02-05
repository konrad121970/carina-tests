package com.solvd.laba.carina.api.fakestoreapi;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.fakestore_api_url}/auth/login", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/fakestore/login_request.json")
public class LoginUser extends AbstractApiMethodV2 {

    public LoginUser() {
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
