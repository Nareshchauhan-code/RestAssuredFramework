package jsonObjecttopojo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ConvertJSONObjectResponseToPOJO {

    @Test
    public void covertJsonObjectToPojo() {

        BookingPojo ob = new BookingPojo();
        ob.setJob("IT");
        ob.setName("Naresh");

        RestAssured.given()
                .body(ob)
                .log().all()
                .post();

        //System.out.println(bookingPojo.getJob());
        //System.out.println(bookingPojo.getName());


    }
}
