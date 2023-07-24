package com.bookingapi;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PathParameters {

    @Test
    void pathParameters() {

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                //.basePath("/{basepath}/{bookingid}")
                .pathParam("basepath", "booking")
                .pathParam("bookingid", 2)
                .log().all()
                .when().get("/{basepath}/{bookingid}")
                .then()
                .statusCode(200)
                .extract().response()
                .prettyPrint();


    }
}
