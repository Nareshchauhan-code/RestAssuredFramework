package adequateshop;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class GetMethods {

    // API URL : http://restapi.adequateshop.com/swagger/ui/index#!/Customer/Customer_GetTravelAgent

    @Test
    public void getData() {

        RestAssured.given()
                .baseUri("http://restapi.adequateshop.com")
                .basePath("/api/Customer")
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response()
                .prettyPrint();

    }
}
