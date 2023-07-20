package RevisonRestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;

public class PostMethod {

    @Test(priority = 1)
    void postMethod() {

        RequestSpecification requestSpecification = given();
        //Given
        requestSpecification.baseUri("http://localhost:9191");
        //requestSpecification.basePath("/normal/webapi/add");
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body(new File("src/test/resources/postData.json"));

        //When
        Response response = requestSpecification.when().post("/normal/webapi/add");

        //Then
        response.then().statusCode(201);
        response.prettyPrint();


    }

    @Test(priority = 2)
    void postMethodBDD() {

        given().baseUri("http://localhost:9191").basePath("/normal/webapi/add").
                header("Content-Type", "application/json").
                body(new File("src/test/resources/postData.json")).
                log().all().
                when().post().
                then().statusCode(201).extract().response().prettyPrint();

    }
}
