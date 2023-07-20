package RevisonRestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetCall {

    @Test
    void getCall() {

        given().baseUri("http://localhost:9191/").log().all()
                .get("/normal/webapi/all").
                then().statusCode(200).extract().
                response().prettyPrint();
    }
}
