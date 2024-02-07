package com.solvd.laba.carina.api.fakestoreapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.laba.carina.api.fakestoreapi.controller.user.DeleteUser;
import com.solvd.laba.carina.api.fakestoreapi.controller.user.GetSingleUser;
import com.solvd.laba.carina.api.fakestoreapi.controller.user.LoginUser;
import com.solvd.laba.carina.api.fakestoreapi.controller.user.UpdateUser;
import com.solvd.laba.carina.api.fakestoreapi.domain.user.Address;
import com.solvd.laba.carina.api.fakestoreapi.domain.user.Geolocation;
import com.solvd.laba.carina.api.fakestoreapi.domain.user.Name;
import com.solvd.laba.carina.api.fakestoreapi.domain.user.User;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserTest {
    private User user;

    @BeforeClass
    public void setUp(){
        Name name = new Name("Andrzej", "Kowalski");
        Geolocation geo = new Geolocation(1.11,2.22);
        Address address = new Address(geo, "Dubiny", "Główna", 161, "17-200");
        user = new User(1, address, "dubiny@hajnowka.pl", "mor_2314", "83r5^_", name, "123123123");
    }

    @Test
    public void verifyGetUserByUserId() {
        GetSingleUser getSingleUser = new GetSingleUser(user.getId());
        getSingleUser.addProperty("user", user);

        String response = getSingleUser.callAPIExpectSuccess().asString();
        ObjectMapper mapper = new ObjectMapper();

        JSONObject jo = new JSONObject(response);
        System.out.println();

        try {
            User responseUser = mapper.readValue(response, User.class);
            System.out.println();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        getSingleUser.validateResponse();
    }

    @Test
    public void verifyUpdateUserById(){
        UpdateUser updateUser = new UpdateUser(user.getId());
        updateUser.addProperty("user", user);

        updateUser.callAPI();

        updateUser.validateResponse();
    }

    @Test
    public void verifyLoginWithValidCredentails(){
        LoginUser loginUser = new LoginUser();
        user.setPassword("83r5^_"); //valid password
        loginUser.addProperty("user", user);

        loginUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        loginUser.callAPI();

        loginUser.validateResponseAgainstSchema("api/fakestore/user/valid_login_response.json");
    }

    @Test
    public void verifyLoginWithInvalidCredentials(){
        LoginUser loginUser = new LoginUser();
        user.setPassword("konrad"); // wrong password
        loginUser.addProperty("user", user);

        loginUser.expectResponseStatus(HttpResponseStatusType.UNAUTHORIZED_401);
        String response = loginUser.callAPI().asString();

        Assert.assertEquals(response, "username or password is incorrect", "Response must match with expected!");
    }

    @Test(dataProvider = "DP1")
    public void verifyDeleteUser(Integer userId){
        User user = new User();
        user.setId(userId);

        DeleteUser deleteUser = new DeleteUser(user.getId());
        deleteUser.addProperty("user", user);
        deleteUser.expectResponseStatus(HttpResponseStatusType.OK_200);

        deleteUser.callAPI();

        deleteUser.validateResponse();
    }

    @DataProvider(name = "DP1")
    public Object[][] provideUSerIds(){
        return new Object[][] {
                {1},
                {2},
                {3},
                {4}
        };
    }

}
