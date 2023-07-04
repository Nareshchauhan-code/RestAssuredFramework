package JobDescription;

import org.testng.annotations.Test;
import utils.RestUtils;

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
                "  \"jobId\": 10,\n" +
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

        RestUtils.performPost(url,payload,new HashMap<>());

    }
}
