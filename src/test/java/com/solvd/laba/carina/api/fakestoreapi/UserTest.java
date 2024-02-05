package com.solvd.laba.carina.api.fakestoreapi;

import com.beust.ah.A;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.laba.carina.api.fakestoreapi.domain.user.Address;
import com.solvd.laba.carina.api.fakestoreapi.domain.user.Geolocation;
import com.solvd.laba.carina.api.fakestoreapi.domain.user.Name;
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

    @Test
    public void verifyUpdateUserById(){
        Name name = new Name("Andrzej", "Kowalski");
        Geolocation geo = new Geolocation(1.11,2.22);
        Address address = new Address(geo, "Dubiny", "Główna", 161, "17-200");
        User user = new User(1, address, "dubiny@hajnowka.pl", "konrad", "asd", name, "123123123");

        UpdateUser updateUser = new UpdateUser(user.getId());

        updateUser.addProperty("user", user);

        updateUser.callAPIExpectSuccess();

        updateUser.validateResponse();

    }


}
