package restassuredtesting;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class GetMethod {
    @Test
    public void getMethod() {

        // Set the Request
        RequestSpecification requestSpecification = given();
        requestSpecification.baseUri("http://localhost:9191");
        requestSpecification.basePath("/normal/webapi/all");
        requestSpecification.contentType(ContentType.JSON);

        // Hit the Http method and Get the Response
        Response response = requestSpecification.get();

        // Validate the Response
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.extract().response().prettyPrint();
        validatableResponse.header("Content-Type", equalTo("application/json"));
        validatableResponse.body("[0].jobId", equalTo(1));
        validatableResponse.body("[0].jobTitle", equalTo("Software Engg"));

    }

    @Test
    public void getRequestInBDDFormat() {

        given()
                .baseUri("http://localhost:9191")
                .basePath("/normal/webapi/all")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .header("Content-Type", equalTo("application/json"))
                .body("[0].jobId", equalTo(1))
                .body("[0].jobTitle", equalTo("Software Engg"))
                .extract()
                .response()
                .prettyPrint();


    }
}
