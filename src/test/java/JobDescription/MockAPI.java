package JobDescription;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class MockAPI {

    @Test
    void mockAPI() {


        JsonPath jsonPath = new JsonPath(PayloadForDemo.payload());
        // Print the courses count
        int count = jsonPath.getInt("courses.size()");
        System.out.println(count);

        // Print purchase amount
        int amount = jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println(amount);

        // First course print
        String course = jsonPath.getString("courses[0].title");
        System.out.println(course);

        // Print the course Title

        for (int i = 0; i < count; i++) {

            String courseTitle = jsonPath.getString("courses[" + i + "].title");
            System.out.println(courseTitle);


        }

        // Print RPA copies sold

        for (int i = 0; i < count; i++) {

            String courseTitle = jsonPath.getString("courses[" + i + "].title");

            if (courseTitle.equalsIgnoreCase("RPA")) {

                int rpacopies = jsonPath.getInt("courses[" + i + "].copies");

                System.out.println("RPA " + rpacopies + " copies Sold");
                break;

            }


        }


    }


}
