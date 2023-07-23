package com.bookingapi;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileReader {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file and parse it into a JsonNode
            JsonNode jsonNode = objectMapper.readTree(new File("src/test/resources/data.json"));

            // Access JSON data
            String name = jsonNode.get("name").asText();
            int age = jsonNode.get("age").asInt();
            String email = jsonNode.get("email").asText();

            // Print the read data
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Email: " + email);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
