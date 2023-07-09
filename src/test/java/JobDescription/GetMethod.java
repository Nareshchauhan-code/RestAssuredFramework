package JobDescription;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetMethod {

    private final String baseURI = "http://localhost:9191/";

    @Test
    void getMethod() {

        Response response = given().baseUri(baseURI).log().all().
                when().get("/normal/webapi/all").
                then().contentType(ContentType.JSON).statusCode(200).
                log().all().extract().response();

        Assert.assertEquals(response.statusCode(), 200);

    }
}
