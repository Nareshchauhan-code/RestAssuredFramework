package com.bookingapi;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PathParameters {

    @Test
    void pathParameters() {

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/{basepath}/{bookingid}")
                .pathParams("basepath", "booking")
                .pathParams("bookingid", 2)
                .log().all()
                .when().get()
                .then()
                .statusCode(200)
                .extract().response()
                .prettyPrint();


    }
}
