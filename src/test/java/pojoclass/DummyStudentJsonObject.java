package pojoclass;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class DummyStudentJsonObject {

    @Test
    public void studentClass() {

        Student student = new Student();
        student.setFirst_Name("Naresh");
        student.setLast_name("Chauhan");
        student.setGender("Male");
        student.setEmail("wwwd@gmail.com");
        student.setAccount_number(100000000);
        student.setAmount(1000.33);


        RestAssured.given()
                .body(student)
                .log().all()
                .get();
    }
}
