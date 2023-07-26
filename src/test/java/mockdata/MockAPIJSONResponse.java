package mockdata;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class MockAPIJSONResponse {

    @Test
    void mockResponse(){

        // https://designer.mocky.io/

        RestAssured.given()
                .baseUri("https://run.mocky.io/v3/f60c36d8-2313-454b-8d50-62dd8bad9251")
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response()
                .prettyPrint();


    }
}
