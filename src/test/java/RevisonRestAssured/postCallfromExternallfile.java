package RevisonRestAssured;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.*;

public class postCallfromExternallfile {

    @Test
    void postData() throws IOException {

        String path = "src/test/resources/postData.json";

        File body = new File(path);

        given().baseUri("http://localhost:9191").header("Content-Type", "application/json").body(body).log().all().
                when().post("/normal/webapi/add").then().statusCode(201).
                extract().response().prettyPrint();

    }
}
