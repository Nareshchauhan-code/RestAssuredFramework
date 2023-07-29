package ProjectLombok;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
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
                .get()
                .prettyPrint();

    }

}
