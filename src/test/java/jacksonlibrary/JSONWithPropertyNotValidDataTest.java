package jacksonlibrary;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSONWithPropertyNotValidDataTest {

    @Test
    public void getData() throws JsonProcessingException {

        JSONWithPropertyNotValidData setValue = new JSONWithPropertyNotValidData();
        setValue.setFirstName("Naresh Chauhan");
        setValue.setLastName("Sonia Chuahan");
        ObjectMapper objectMapper = new ObjectMapper();
        // Covert Object to String
        String updatedValues = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(setValue);
        System.out.println(updatedValues);

        // Covert String to Object

        JSONWithPropertyNotValidData jsonWithPropertyNotValidData = objectMapper.readValue(updatedValues, JSONWithPropertyNotValidData.class);
        System.out.println(jsonWithPropertyNotValidData.getFirstName());
        System.out.println(jsonWithPropertyNotValidData.getLastName());

        // Assertion

        Assert.assertEquals(jsonWithPropertyNotValidData.getFirstName(), "Naresh Chauhan");
        Assert.assertEquals(jsonWithPropertyNotValidData.getLastName(), "Sonia Chuahan");

    }
}
