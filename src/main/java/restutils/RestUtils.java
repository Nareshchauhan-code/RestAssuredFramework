package restutils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {

    public static Response performPost(String url, String requestPayload, Map<String, String> headers) {

        Response response = RestAssured.given().log().all()
                .baseUri(url).
                headers(headers).
                contentType(ContentType.JSON).
                body(requestPayload).
                post().then().log().all()
                .extract().response();
        return response;
    }

}
