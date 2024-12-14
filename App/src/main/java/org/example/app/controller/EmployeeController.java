package org.example.app.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.example.app.Models.Employee;
import org.example.app.service.EmployeeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class EmployeeController {
    private final EmployeeServices service = new EmployeeServices();
    @PostMapping("/addEmployee")
    public String add(@RequestBody Employee employee){
        System.out.println(employee);
        service.addEmployee(employee);
        return "employee";
    }
}
