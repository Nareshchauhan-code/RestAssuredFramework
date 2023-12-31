package JobDescription;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restutils.RestUtils;

import java.util.HashMap;

public class PostJob {

    @Test
    public void postJob(){

        String url = "http://localhost:9191/normal/webapi/add";
        String payload ="{\n" +
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

        Response response = RestUtils.performPost(url, payload, new HashMap<>());

        Assert.assertEquals(response.statusCode(),201,"Testcase Failed");

    }
}
