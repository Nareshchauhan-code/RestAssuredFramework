package com.bookingapi;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetBookingBDDApproch {

    @Test
    void getBooking() {

        // Build the Request
        RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/{id}")
                .pathParams("id", 1).log().all()

                // Hit the Request and get the Response
                .get()
                // Validate the Response
                .then().log().all()
                .statusCode(200)
                .extract().response().prettyPrint();
    }
}
