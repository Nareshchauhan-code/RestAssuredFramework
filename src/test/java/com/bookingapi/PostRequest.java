package com.bookingapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PostRequest {

    @Test
    void postRequest() {

        RequestSpecification requestSpecification = RestAssured.given();
        // Set the Request
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body("{\"firstname\":\"Jim\",\"lastname\":\"Brown\",\"totalprice\":111,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2018-01-01\",\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}");
        requestSpecification.log().all();

        // Hit the Request and get the Response

        Response response = requestSpecification.when().get();
        response.prettyPrint();

        // Validation

        ValidatableResponse validation = response.then();
        validation.log().all();
        validation.assertThat().statusCode(200);


    }
}
