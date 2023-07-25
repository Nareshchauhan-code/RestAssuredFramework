package com.bookingapi;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class InlineAssertion {

    @Test
    void InlineAssertion() {

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .body("{\"username\":\"admin\",\"password\":\"password123\"}")
                .when()
                .post()
                .then()
                .log().all()
                .body("token", Matchers.notNullValue())
                .body("token.length()", Matchers.greaterThan(10));

    }
}
