package jacksonlibrary;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class CustDataReadFromJson {

    @Test
    public void covertJsontoPojo() throws IOException {

        String path = ".\\src\\test\\resources\\payloads\\custdata.json";

        ObjectMapper objectMapper = new ObjectMapper();
        CustomerPojo customerPojo = objectMapper.readValue(new File(path), CustomerPojo.class);

        // Set the Values

        customerPojo.setFirstname("Naresh");
        customerPojo.setLastname("Chauhan");
        customerPojo.setDepositpaid(false);
        customerPojo.setTotalprice(100000);

        // Get the Updated Values
        System.out.println(customerPojo.getFirstname());
        System.out.println(customerPojo.getLastname());
        System.out.println(customerPojo.isDepositpaid());
        System.out.println(customerPojo.getTotalprice());


    }
}
