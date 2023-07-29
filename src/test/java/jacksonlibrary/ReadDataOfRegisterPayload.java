package jacksonlibrary;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ReadDataOfRegisterPayload {

    @Test
    public void registerDataReadFromPayload() throws IOException {

       String path = ".\\src\\test\\resources\\payloads\\rigister.json";

        ObjectMapper objectMapper = new ObjectMapper();
       RegisterPojo registerPojo= objectMapper.readValue(new File(path),RegisterPojo.class);
        registerPojo.setEmail("nareshchauhan2014@gmail.com");
        registerPojo.setPassword("123456");

        System.out.println(registerPojo.getEmail());
        System.out.println(registerPojo.getPassword());

    }
}
