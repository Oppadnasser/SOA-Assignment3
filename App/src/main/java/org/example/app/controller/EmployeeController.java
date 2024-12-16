package org.example.app.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.example.app.Models.Employee;
import org.example.app.service.EmployeeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {
    private final EmployeeServices service = new EmployeeServices();
    @PostMapping("/addEmployee")
    public String add(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }
    @PostMapping("/update")
    public String update(@RequestParam int id, @RequestParam String value , @RequestParam String field){
        return service.update(id,field,value);
    }
    @PostMapping("/updatelanguage")
    public String updateLanguage(@RequestParam int id, @RequestParam String language, @RequestParam int score){
        return service.updateLanguage(id,language,score);
    }
    @GetMapping("/searchById")
    public List<Employee> searchById(@RequestParam String employeeId)
    {
        return service.searchEmployeeById(employeeId);
    }
    @GetMapping("/searchByDesignation")
    public List<Employee> searchByDesignation(@RequestParam String designation)
    {
        return service.searchEmployeeByDesignation(designation);
    }

    @DeleteMapping("/deleteEmployee")
    public String deleteEmployeeById(@RequestParam String employeeId)
    {
        return service.deleteEmployeeById(employeeId);
    }
}
