package JobDescription;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PostMethod {

    @Test
    void voidRequest() {

        String payload = "{\n" +
                "  \"experience\": [\n" +
                "    \"Java\"\n" +
                "  ],\n" +
                "  \"jobDescription\": \"Testing\",\n" +
                "  \"jobId\": 12,\n" +
                "  \"jobTitle\": \"QA\",\n" +
                "  \"project\": [\n" +
                "    {\n" +
                "      \"projectName\": \"Selenium\",\n" +
                "      \"technology\": [\n" +
                "        \"Java\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Response response = RestAssured.given().baseUri("http://localhost:9191/").body(payload).log().all().
                when().post("/normal/webapi/add").then().extract().response();

        response.prettyPrint();


    }
}
