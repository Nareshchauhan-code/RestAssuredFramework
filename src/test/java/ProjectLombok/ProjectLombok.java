package ProjectLombok;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ProjectLombok {

    @Test
    public void getBookingData() {

        Bookingpojo bookingpojo = new Bookingpojo();
        bookingpojo.setFirstname("Naresh");
        bookingpojo.setLastname("Chauhan");
        bookingpojo.setTotalprice(10000);
        bookingpojo.setDepositpaid(true);

        RestAssured.given()
                .baseUri("https://run.mocky.io/v3/568b7d78-03bc-4b5d-99ec-4b215b5e093d")
                .post(String.valueOf(bookingpojo))
                .prettyPrint();

    }

}
