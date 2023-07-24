package com.bookingapi;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResponseSpecificationsDemo {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @BeforeClass
    void setRequestSpecificationDemo() {

        requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.log().all();

    }

    @BeforeClass
    void setResponseSpecificationDemo() {

        responseSpecification = RestAssured.expect();
        responseSpecification.statusCode(200);
        responseSpecification.time(Matchers.lessThan(5000l));
        responseSpecification.log().all();

    }

    @Test(priority = 1)
    void postRequest() {

        RestAssured.given(requestSpecification).
                body("{\"firstname\":\"Jim\",\"lastname\":\"Brown\",\"totalprice\":111,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2018-01-01\",\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}")
                .when()
                .get()
                .then().spec(responseSpecification);

    }

}
