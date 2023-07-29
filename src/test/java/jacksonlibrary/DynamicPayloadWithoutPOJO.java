package jacksonlibrary;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class DynamicPayloadWithoutPOJO {

    @Test
    public void dynamicPayloadWithoutPOJO() throws IOException {

        String path = ".\\src\\test\\resources\\payloads\\custdata.json";

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(new File(path), new TypeReference<Map<String, Object>>() {});
        map.put("firstname","Kapil");
        String updatedValue = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        System.out.println(updatedValue);
    }
}
