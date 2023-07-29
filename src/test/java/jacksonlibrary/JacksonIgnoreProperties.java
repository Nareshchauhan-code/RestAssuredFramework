package jacksonlibrary;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class JacksonIgnoreProperties {

    @Test
    public void jacksonIgnoreProperties() throws JsonProcessingException {

        // Change in Payload and get exeption : com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException: Unrecognized field "age" (class jacksonlibrary.CustomerPojo), not marked as ignorable (4 known properties: "lastname", "depositpaid", "firstname", "totalprice"])
        String payload = "{\n" +
                "\t\"firstname\": \"Naresh\",\n" +
                "\t\"lastname\": \"Chauhan\",\n" +
                "\t\"totalprice\": 10000,\n" +
                "\t\"depositpaid\": true,\n" +
                "\t\"age\" : 30\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        CustomerPojo customerPojo = objectMapper.readValue(payload, CustomerPojo.class);

        System.out.println(customerPojo.getFirstname());
        System.out.println(customerPojo.getLastname());
        System.out.println(customerPojo.getTotalprice());
        System.out.println(customerPojo.isDepositpaid());
    }


}
