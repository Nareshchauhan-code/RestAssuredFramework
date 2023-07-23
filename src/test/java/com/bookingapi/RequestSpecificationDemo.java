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
                body("{\"firstname\":\"Jim\",\"lastname\":\"Brown\",\"totalprice\":111,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2018-01-01\",\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}");

        // Hit the Request and get the Response
        Response response = requestSpecification.when().get();
        response.prettyPrint();
        // Validation
        ValidatableResponse validation = response.then();
        validation.log().all();
        validation.assertThat().statusCode(200);


    }


}
