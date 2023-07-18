package RevisonRestAssured;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;

public class postCallfromExternallfile {

    @Test
    void postData() throws IOException {

        String body = new String(Files.readAllBytes(Paths.get("src/test/resources/postData.json")));

        given().baseUri("http://localhost:9191").header("Content-Type", "application/json").body(body).log().all().
                when().post("/normal/webapi/add").then().statusCode(201).
                extract().response().prettyPrint();

    }
}
