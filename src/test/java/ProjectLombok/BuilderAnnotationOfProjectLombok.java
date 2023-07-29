package ProjectLombok;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class BuilderAnnotationOfProjectLombok {

    @Test
    public void builderAnnotationOfProjectLombok() throws JsonProcessingException {

        EmployeeDataforLombok employeeDataforLombok = EmployeeDataforLombok.builder().fristName("Sonu").lastName("CHauhan")
                .age(32).gender("Female").build();

        ObjectMapper objectMapper = new ObjectMapper();
        String payload=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeDataforLombok);
        System.out.println(payload);

        EmployeeDataforLombok epmloyee1= employeeDataforLombok.toBuilder().fristName("Naresh").lastName("Chauhan")
                .age(35).gender("Male").build();

        ObjectMapper objectMapper1 = new ObjectMapper();
        String payload1=objectMapper1.writerWithDefaultPrettyPrinter().writeValueAsString(epmloyee1);
        System.out.println(payload1);



    }
}
