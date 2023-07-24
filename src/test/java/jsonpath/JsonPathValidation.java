package jsonpath;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class JsonPathValidation {

    @Test
    void jsonPathValidation(){

        String value = "{\"firstname\":\"Jim\",\"lastname\":\"Brown\",\"totalprice\":111,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2018-01-01\",\"checkout\":\"2019-01-01\"}}";

        JsonPath jsonPath = new JsonPath(value);

        String name = jsonPath.getString("firstname");
        System.out.println(name);

        //System.out.println(jsonPath.prettyPrint());

        System.out.println(jsonPath.getString("lastname"));
    }
}
