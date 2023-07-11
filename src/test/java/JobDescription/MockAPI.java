package JobDescription;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class MockAPI {

    @Test
    void mockAPI() {


        JsonPath js = new JsonPath(PayloadForDemo.payload());
        //Print No of courses returned by API

        int count = js.getInt("courses.size()");
        System.out.println(count);

    }


}
