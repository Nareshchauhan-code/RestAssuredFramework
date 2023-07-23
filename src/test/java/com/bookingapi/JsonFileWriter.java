package com.bookingapi;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonFileWriter {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Create an ObjectNode to represent the JSON data
            ObjectNode jsonData = objectMapper.createObjectNode();
            jsonData.put("name", "John Doe");
            jsonData.put("age", 30);
            jsonData.put("email", "john.doe@example.com");

            // Convert the ObjectNode to JSON and write it to a file
            objectMapper.writeValue(new File("src/test/resources/output.json"), jsonData);

            System.out.println("JSON data has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
