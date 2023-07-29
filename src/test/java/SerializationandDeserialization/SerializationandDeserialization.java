package SerializationandDeserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SerializationandDeserialization {

    @Test
    public void serializationandDeserialization() throws JsonProcessingException {

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Naresh");
        bookingPojo.setLastname("Chauhan");
        bookingPojo.setTotalprice(10000);
        bookingPojo.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2023-01-10");
        bookingdates.setCheckout("2023-02-10");

        bookingPojo.setBookingdates(bookingdates);
        bookingPojo.setAdditionalneeds("TEA");

        // Serialization

        ObjectMapper objectMapper = new ObjectMapper();
        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingPojo);
        System.out.println(payload);

        String response = "{\n" +
                "    \"firstname\" : \"Naresh\",\n" +
                "    \"lastname\" : \"Chauhan\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        //Deserialization
        BookingPojo afterDe = objectMapper.readValue(response, BookingPojo.class);

        System.out.println(afterDe.getBookingdates().getCheckin());
        System.out.println(afterDe.getBookingdates().getCheckout());
        System.out.println(afterDe.getFirstname());

        Assert.assertEquals(afterDe.getFirstname(), "Naresh");


    }
}
