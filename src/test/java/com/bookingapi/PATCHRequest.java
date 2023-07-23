package com.bookingapi;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PATCHRequest {

    @Test(priority = 1)
    void patchRequest() {

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("booking/1")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body("{\"firstname\":\"Naresh\",\"lastname\":\"Brown\"}")
                .log().all()
                .when()
                .patch()
                .then()
                .statusCode(200)
                .extract()
                .response()
                .prettyPrint();

    }

    @Test(priority = 2)
    void getBooking() {

        // Build the Request
        given().
                baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/{id}")
                .pathParams("id", 1).log().all()

                // Hit the Request and get the Response
                .when().get()
                // Validate the Response
                .then().log().all()
                .statusCode(200)
                .extract().response().prettyPrint();
    }
}
