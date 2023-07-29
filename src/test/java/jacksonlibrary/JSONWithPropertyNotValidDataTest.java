package jacksonlibrary;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class JSONWithPropertyNotValidDataTest {

    @Test
    public void getData() throws JsonProcessingException {

        JSONWithPropertyNotValidData setValue = new JSONWithPropertyNotValidData();
        setValue.setFirstName("Naresh Chauhan");
        setValue.setLastName("Sonia Chuahan");
        ObjectMapper objectMapper = new ObjectMapper();
        String updatedValues = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(setValue);
        System.out.println(updatedValues);

    }
}
