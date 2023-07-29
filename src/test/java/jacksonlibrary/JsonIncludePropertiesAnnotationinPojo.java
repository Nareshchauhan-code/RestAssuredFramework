package jacksonlibrary;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class JsonIncludePropertiesAnnotationinPojo {

    @Test
    public void jsonIncludeProperty() throws JsonProcessingException {

        CustomerPojoForJsonAnotation customerPojoForJsonAnotation = new CustomerPojoForJsonAnotation();
        customerPojoForJsonAnotation.setFirstname("Billu");
        customerPojoForJsonAnotation.setLastname("Barber");

        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(customerPojoForJsonAnotation);

        System.out.println(value);

    }
}
