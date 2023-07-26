package PayloadCreation;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CreateComplexRequestUsingMapandList {

    @Test
    void createComplexRequest() {

        /*

        Sample Payload :

        {
	"storeName": "TechHub",
	"location": "Cityville",
	"contactEmail": "contact@techhub.com",
	"inventory": {
		"categories": [
			{
				"categoryId": 1,
				"categoryName": "Laptops"

			},
			{
				"categoryId": 2,
				"categoryName": "Smartphones"

			}
		]
	}
}


         */

        // Parent Json Object
        Map<String, Object> finalPayload = new LinkedHashMap<String, Object>();

        finalPayload.put("storeName", "TechHub");
        finalPayload.put("location", "Cityville");
        finalPayload.put("contactEmail", "contact@techhub.com");


        Map<String, Object> categoryOne = new LinkedHashMap<String, Object>();
        categoryOne.put("categoryId", 1);
        categoryOne.put("categoryName", "Laptops");

        Map<String, Object> categoryTwo = new LinkedHashMap<String, Object>();
        categoryTwo.put("categoryId", 2);
        categoryTwo.put("categoryName", "Smartphones");

        List<Map<String, Object>> categories = new ArrayList<>();
        categories.add(categoryOne);
        categories.add(categoryTwo);

        Map<String, Object> inventoryValue = new LinkedHashMap<String, Object>();
        inventoryValue.put("categories", categories);

        finalPayload.put("inventory", inventoryValue);

        RestAssured.given()
                .body(finalPayload)
                .log().all()
                .get()
                .then()
                .log().all();


    }
}
