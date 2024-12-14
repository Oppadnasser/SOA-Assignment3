package org.example.app.Models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class JSONFileHandler {
    private static final String FILE_PATH = "employees.json";
    public void save(List<Employee> employees) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), employees);
            System.out.println("Data successfully written to " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public List<Employee> load() {
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        File file = new File(FILE_PATH);
        try {
            if (!file.exists()) {
                // If the file doesn't exist, create a new one
                file.createNewFile();

                // Return an empty list
                return new ArrayList<>();
            }
            List<Employee> employees =  objectMapper.readValue(new File(FILE_PATH), new TypeReference<List<Employee>>() {
            });
            return employees;
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return null;
    }
}
