package RevisonRestAssured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetCall {

    @Test
    void getCall() {

        RestAssured.given().baseUri("http://localhost:9191/").log().all()
                .get("/normal/webapi/all").then().statusCode(200).extract().response().prettyPrint();
    }
}
