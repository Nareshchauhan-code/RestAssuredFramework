package com.bookingapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

public class JSONSchemaValidation {

    @Test
    void jSONSchemaValidation() {

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .body("{\"firstname\":\"Jim\",\"lastname\":\"Brown\",\"totalprice\":111,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2018-01-01\",\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}")
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("CreateBookingJsonSchema.json"));

    }
}
