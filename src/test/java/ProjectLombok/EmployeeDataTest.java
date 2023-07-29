package ProjectLombok;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class EmployeeDataTest {

    @Test
    void employeeData() {

        EmployeeData employeeData = new EmployeeData();
        employeeData.setFristName("Kapil");
        employeeData.setLastName("Chauhan");
        employeeData.setGender("Male");
        employeeData.setAge(32);

        RestAssured.given()
                .baseUri("https://run.mocky.io/v3/fb54b227-94d4-4e7d-9a09-ffb3761857e2")
                .post(String.valueOf(employeeData))
                .prettyPrint();


    }


}
