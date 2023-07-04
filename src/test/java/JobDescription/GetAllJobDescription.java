package JobDescription;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetAllJobDescription {

    @Test
    public void getAllJobDescription(){


        RestAssured.given().baseUri("http://localhost:9191/normal/webapi/all").
                get().
                prettyPrint();

    }

}
