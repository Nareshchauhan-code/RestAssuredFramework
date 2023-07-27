package pojoclass.nestedpojo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class GetMemberDetails {

    @Test
    public void getMemberDetails() {

        Member member = new Member();
        member.setFirst_Name("Naresh");
        member.setLast_name("Chauhan");
        member.setEmail("NareshChauhan2014@gmail.com");
        member.setGender("Male");

        Address address1 = new Address();
        address1.setCity("Delhi");
        address1.setCountry("India");
        address1.setState("Delhi");

        Address address2 = new Address();
        address2.setCity("Aligarh");
        address2.setCountry("India");
        address2.setState("UP");

        List<Address> addressList = new ArrayList<Address>();
        addressList.add(address1);
        addressList.add(address2);

        member.setAddress(addressList);

        RestAssured.given()
                .body(member)
                .log().all()
                .get();
    }

}
