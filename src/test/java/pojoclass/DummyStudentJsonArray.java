package pojoclass;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class DummyStudentJsonArray {

    @Test
    public void studentClass() {

        Student first_student = new Student();
        first_student.setFirst_Name("Naresh");
        first_student.setLast_name("Chauhan");
        first_student.setGender("Male");
        first_student.setEmail("wwwd@gmail.com");
        first_student.setAccount_number(100000000);
        first_student.setAmount(1000.33);

        Student second_Student = new Student();
        second_Student.setFirst_Name("Hari");
        second_Student.setLast_name("Sharma");
        second_Student.setGender("Male");
        second_Student.setEmail("wwssssswd@gmail.com");
        second_Student.setAccount_number(200000);
        second_Student.setAmount(2000.33);

        List<Object> finalValue = new ArrayList<Object>();
        finalValue.add(first_student);
        finalValue.add(second_Student);


        RestAssured.given()
                .body(finalValue)
                .log().all()
                .get();
    }
}
