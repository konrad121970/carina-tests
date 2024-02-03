package com.solvd.laba.carina.api.github;

import com.solvd.laba.carina.domain.User;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class UserTest {

    @Test
    public void verifyGetUserByUsername(){

        User user = new User();
        user.setUsername("konrad121970");
        user.setFirstName("Konrad");
        user.setLastName("Pawlenko");

        GetUserByUsername getUserByUsername = new GetUserByUsername(user.getUsername());
        getUserByUsername.addProperty("user", user);

        getUserByUsername.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUserByUsername.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                        .<String>withPredicate("datePredicate", date -> isDateValid(date) && ZonedDateTime.parse(date).isAfter(LocalDate.of(2000,1,1).atStartOfDay(ZoneId.systemDefault())));

        getUserByUsername.validateResponse(comparatorContext);


    }

    private boolean isDateValid(String date){
        try{
            ZonedDateTime.parse(date);
            return true;
        } catch (DateTimeException e){
            return false;
        }
    }

}
