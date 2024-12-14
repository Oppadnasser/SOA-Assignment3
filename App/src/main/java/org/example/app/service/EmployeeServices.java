package org.example.app.service;

import org.example.app.Models.Employee;
import org.example.app.Models.JSONFileHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServices {
    private List<Employee> employees;
    private final JSONFileHandler handler = new JSONFileHandler();
    public void addEmployee(Employee E){
        employees = handler.load();
        if(employees == null){
            employees = new ArrayList<Employee>();
        }
        employees.add(E);
        handler.save(employees);
    }
}
