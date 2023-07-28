package pojoclass.nestedpojo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetMemberDetails {

    @Test
    public void getMemberDetails() {

        Member member = new Member();
        member.setFirst_Name("Naresh");
        member.setLast_name("Chauhan");
        member.setEmail("NareshChauhan2014@gmail.com");
        member.setGender("Male");

        Address address = new Address();
        address.setCity("Delhi");
        address.setCountry("India");
        address.setState("Delhi");
        member.setAddress(address);

        RestAssured.given()
                .body(member)
                .log().all()
                .get();
    }

}
