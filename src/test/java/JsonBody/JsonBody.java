package JsonBody;

import net.datafaker.Faker;

public class JsonBody {


    public static String payload() {

        Faker faker = new Faker();
        String randomNumber = faker.number().digit();

        String jsonRequest = "{\n" +
                "  \"jobId\" : " + randomNumber + ",\n" +
                "  \"jobTitle\" : \"IT\",\n" +
                "  \"jobDescription\" : \"To develop ios application\",\n" +
                "  \"experience\" : [ \"Google\", \"Apple\", \"Mobile Iron\" ],\n" +
                "  \"project\" : [ {\n" +
                "    \"projectName\" : \"Movie App\",\n" +
                "    \"technology\" : [ \"Kotlin\", \"SQL Lite\", \"Gradle\" ]\n" +
                "  } ]\n" +
                "}\n";

        return jsonRequest;

    }


}