package com.bookingapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqRes {

    @Test
    void reqresGet() {

        // Set the Value
        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://reqres.in");
        requestSpecification.basePath("/api/users?page=2");
        requestSpecification.contentType(ContentType.JSON);

        // Action or Hit the Request and Get the Response

        Response response = requestSpecification.get();

        // Validation

        response.then().statusCode(200);
        response.prettyPrint();


    }

}
