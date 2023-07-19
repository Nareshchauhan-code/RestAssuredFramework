package RevisonRestAssured;

import JsonBody.JsonBody;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PostMethodDynamic {

    @Test(priority = 1)
    void postMethod() {


        given().
                baseUri("http://localhost:9191").
                header("Content-Type", "application/json").
                body(JsonBody.payload()).log().all().
                when().post("/normal/webapi/add")
                .then().statusCode(201).
                extract().response().
                prettyPrint();

    }


}
