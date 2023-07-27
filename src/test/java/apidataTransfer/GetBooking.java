package apidataTransfer;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetBooking {

    @Test
    void getBooking(ITestContext context){

        // Build the Request
        RequestSpecification requestSpecification =RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/{id}");
        requestSpecification.pathParams("id",context.getSuite().getAttribute("bookingid")).log().all();

        // Hit the Request and get the Response

        Response response =requestSpecification.get();

        // Validate the Response

        ValidatableResponse validation = response.then().log().all();
        validation.statusCode(200);
        validation.extract().response().prettyPrint();
    }
}
