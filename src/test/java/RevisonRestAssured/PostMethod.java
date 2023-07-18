package RevisonRestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

public class PostMethod {

    @Test
    void postMethod() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("http://localhost:9191");
        requestSpecification.basePath("/normal/webapi/add");
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body(new File("src/test/resources/postData.json"));
        Response response = requestSpecification.post();
        response.then().statusCode(201);
        response.prettyPrint();


    }
}
