package deserializationdemo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ConvertDynamicJSONResponse {

    @Test
    public void convertDynamicJSONResponse() {

        // https://designer.mocky.io/

        Response response = RestAssured.given()
                .baseUri("https://run.mocky.io/v3/f60c36d8-2313-454b-8d50-62dd8bad9251")
                .get();

        response.prettyPrint();

        Object object = response.as(Object.class);

        if (object instanceof Map) {

            Map map = response.as(Map.class);
            System.out.println(map.keySet());
        } else if (object instanceof List) {

            List list = response.as(List.class);

            System.out.println(list.size());

        }

    }
}
