package JobDescription;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonValueExtract {

    @Test
    void jsonValueExtract() {

        String response = given().baseUri("http://localhost:9191").log().all()
                .when().get("/normal/webapi/all").
                then().statusCode(200).log().all().extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        System.out.println("The Job ID is : " + jsonPath.getString("[0].jobId"));

    }
}
