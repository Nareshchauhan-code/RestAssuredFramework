package jsonObjecttopojo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ConvertJSONObjectResponseToPOJO {

    @Test
    public void covertJsonObjectToPojo() {

        BookingPojo bookingPojo = RestAssured.get("https://run.mocky.io/v3/321140d1-3943-4bd0-a35d-e258462f8191")
                .as(BookingPojo.class);

        System.out.println(bookingPojo.getJob());
        System.out.println(bookingPojo.getName());


    }
}
