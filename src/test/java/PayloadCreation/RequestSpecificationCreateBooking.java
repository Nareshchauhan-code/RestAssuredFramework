package PayloadCreation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class RequestSpecificationCreateBooking {

    @Test
    void createBooking() {

        RequestSpecification requestSpecification = RestAssured.given();

        // set the Request

        Map<String, Object> bookingPayload = new LinkedHashMap<String, Object>();
        bookingPayload.put("firstname", "Naresh Chauhan");
        bookingPayload.put("lastname", "Brown");
        bookingPayload.put("totalprice", "10000");
        bookingPayload.put("depositpaid", true);

        Map<String, Object> dates = new LinkedHashMap<String, Object>();
        dates.put("checkin", "2013-02-23");
        dates.put("checkout", "2014-10-23");

        bookingPayload.put("bookingdates", dates);
        bookingPayload.put("additionalneeds", "Breakfast");

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(bookingPayload);

        // Hit the Request and Get the Response

        Response response = requestSpecification.post();
        System.out.println(response.prettyPrint());

        // Validation

        ValidatableResponse responseValidation = response.then();
        responseValidation.statusCode(200);
        responseValidation.extract().asPrettyString();

    }
}
