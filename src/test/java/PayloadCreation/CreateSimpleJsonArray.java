package PayloadCreation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CreateSimpleJsonArray {

    @Test
    void createSimpleJsonArray() {


        Map<String, Object> emp1 = new LinkedHashMap<String, Object>();

        emp1.put("id", 1);
        emp1.put("first_name", "Rick");
        emp1.put("last_name", "Rushby");
        emp1.put("email", "rrushby0@stanford.edu");
        emp1.put("gender", "Male");

        Map<String, Object> emp2 = new LinkedHashMap<String, Object>();

        emp2.put("id", 2);
        emp2.put("first_name", "Milissent");
        emp2.put("last_name", "Leamy");
        emp2.put("email", "mleamy1@sitemeter.com");
        emp2.put("gender", "Male");

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(emp1);
        list.add(emp2);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(list)
                .log().all()
                .post()
                .then()
                .log().all();

    }
}
