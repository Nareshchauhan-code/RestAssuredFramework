package com.bookingapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WithoutInlineAssertion {

    @Test
    void withoutInlineAssertion() {

        String response = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .body("{\"username\":\"admin\",\"password\":\"password123\"}")
                .when()
                .post()
                .then()
                .log().all()
                .extract()
                .response()
                .asString();

        JsonPath jsonPath = new JsonPath(response);
        String token = jsonPath.getString("token");

        Assert.assertNotNull(token);
        //Assert.assertNull(token);


    }
}
