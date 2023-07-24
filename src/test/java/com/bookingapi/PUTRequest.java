package com.bookingapi;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PUTRequest {

    @Test
    void putRequest() {

        HashMap<String, Object> mapHeader = new HashMap<String, Object>();
        mapHeader.put("Content-Type", "application/json");
        mapHeader.put("Accept", "application/json");
        mapHeader.put("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=");
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/1")
                .headers(mapHeader)
                .body("{\"firstname\":\"James\",\"lastname\":\"Brown\",\"totalprice\":111,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2018-01-01\",\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}")
                .when()
                .put()
                .then()
                .statusCode(200)
                .extract()
                .response()
                .prettyPrint();
    }
}
