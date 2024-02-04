package com.solvd.laba.carina.api.fakestoreapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.laba.carina.api.fakestoreapi.domain.user.User;
import com.zebrunner.agent.core.registrar.domain.ObjectMapperImpl;
import org.testng.annotations.Test;

public class UserTest {

    @Test
    public void verifyGetUserByUserId() {

        User user = new User();
        user.setId(1);

        GetSingleUser getSingleUser = new GetSingleUser(user.getId());
        getSingleUser.addProperty("user", user);

        String response = getSingleUser.callAPIExpectSuccess().asString();
        ObjectMapper mapper = new ObjectMapper();

        try {
            user = mapper.readValue(response, User.class);
            System.out.println();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        getSingleUser.validateResponse();
    }


}
