package jsonObjecttopojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerGetData {

    @Test
    public void getData() {

        CustomerDataPojo customerDataPojo = new CustomerDataPojo();
        customerDataPojo.setFirstname("Naresh");
        customerDataPojo.setLastname("Chauhan");
        customerDataPojo.setDepositpaid(true);
        customerDataPojo.setTotalprice(100000);


        Bookingdatespojo bookingdatespojo = new Bookingdatespojo();
        bookingdatespojo.setCheckin("2023-05-01");
        bookingdatespojo.setCheckout("2023-06-10");

        customerDataPojo.setBookingdates(bookingdatespojo);
        customerDataPojo.setAdditionalneeds("Nothing");

        System.out.println(customerDataPojo.firstname);
        System.out.println(customerDataPojo.lastname);

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://run.mocky.io/");
        requestSpecification.basePath("/v3/6a67008e-3273-47a6-b130-ccf7fcd3d849");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(customerDataPojo);
        requestSpecification.log().all();
        Response response = requestSpecification.post();
        requestSpecification.then().statusCode(200);

        Assert.assertEquals(customerDataPojo.firstname, "Naresh");


    }
}
