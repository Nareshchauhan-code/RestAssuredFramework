package restassuredtesting;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class PostMethod {
    @Test
    void postMethod() throws JsonProcessingException {


        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("name", "morpheus");
        map.put("job", "leader");

        RestAssured.given()
                .baseUri("https://reqres.in/api/users")
                .contentType(ContentType.JSON)
                .body(map)
                .when()
                .post()
                .then()
                .extract()
                .response()
                .prettyPrint();

    }
}
