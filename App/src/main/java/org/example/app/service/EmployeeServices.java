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
    public String addEmployee(Employee E){
        employees = handler.load();
        if(employees == null){
            employees = new ArrayList<Employee>();
        }
        for(Employee e : employees){
            if(e.getEmployeeID() == E.getEmployeeID()){
                return "this Id used before";
            }
        }
        employees.add(E);
        handler.save(employees);
        return "added successfully";
    }

    public String update(int id, String designation){
        employees = handler.load();
        if(employees == null){
            employees = new ArrayList<Employee>();
        }
        for(Employee e : employees){
            if(e.getEmployeeID() == id){
                e.setDesignation(designation);
                handler.save(employees);
                return "updated successfully";
            }
        }
        return "There is no employee with this id";
    }
}
