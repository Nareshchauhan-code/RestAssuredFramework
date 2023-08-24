package PayloadCreation.SerializationandDeserialization;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class JsonBodyValidation {

    @Test
    public void jsonBodyValidation() {
        // Json Object Validation
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/booking/1")
                .when()
                .get()
                .then()
                .log().all()
                .body("", Matchers.instanceOf(Map.class));

        // Json Array Validation

        RestAssured.given()
                .baseUri("https://run.mocky.io/v3/283bb7cb-f56f-4e51-b1ff-7828ed169d4c")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .log().all()
                .body("", Matchers.instanceOf(List.class));



    }

}
