package jacksonlibrary;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class JacksonAnnotations {

    @Test
    public void JacksonAnnotations() throws JsonProcessingException {

        CustomerPojo customerPojo = new CustomerPojo();
        customerPojo.setFirstname("Billu");
        customerPojo.setLastname("Barber");

        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(customerPojo);

        System.out.println(value);


    }
}
