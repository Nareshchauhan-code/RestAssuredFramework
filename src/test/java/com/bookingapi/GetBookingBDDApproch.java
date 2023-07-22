package com.bookingapi;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetBookingBDDApproch {

    @Test
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
