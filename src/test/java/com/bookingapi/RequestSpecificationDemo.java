package com.bookingapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestSpecificationDemo {

    RequestSpecification requestSpecification;

    @BeforeClass
    void setRequestSpecificationDemo() {

        requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.log().all();

    }

    @Test(priority = 1)
    void postRequest() {

        RestAssured.given().spec(requestSpecification).
                body("{\"firstname\":\"Jim\",\"lastname\":\"Brown\",\"totalprice\":111,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2018-01-01\",\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .asPrettyString();


    }


}
