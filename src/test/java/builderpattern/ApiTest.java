package builderpattern;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiTest {
    public static void main(String[] args) {
        String baseUrl = "https://reqres.in";
        String endpoint = "/api/users";

        String requestBody = "{\"name\":\"morpheus\",\"job\":\"leader\"}";

        RequestSpecification requestSpec = new RequestBuilder(baseUrl)
                .setEndpoint(endpoint)
                .setContentType(ContentType.JSON)
                .setRequestBody(requestBody)
                .build();

        requestSpec.when()
                .post()
                .then()
                .statusCode(201)
                .extract()
                .response()
                .prettyPrint();

    }
}
