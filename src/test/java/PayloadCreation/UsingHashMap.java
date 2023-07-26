package PayloadCreation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class UsingHashMap {

    @Test
    void usingHashmap() {

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

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .body(bookingPayload)
                .log().all()
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response()
                .prettyPrint();


    }
}
