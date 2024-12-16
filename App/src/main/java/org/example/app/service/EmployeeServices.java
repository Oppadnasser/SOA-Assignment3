package org.example.app.service;

import org.example.app.Models.Employee;
import org.example.app.Models.JSONFileHandler;
import org.example.app.Models.KnownLanguage;
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

    public String update(int id, String field , String value){
        employees = handler.load();
        if(employees == null){
            employees = new ArrayList<Employee>();
        }
        for(Employee e : employees){
            if(e.getEmployeeID() == id){
                e.setField(field,value);
                handler.save(employees);
                return "updated successfully";
            }
        }
        return "There is no employee with this id";
    }
    public String updateLanguage(int id, String language, int score){
        employees = handler.load();
        if(employees == null){
            employees = new ArrayList<Employee>();
        }
        for(Employee e : employees){
            if(e.getEmployeeID() == id){
                List<KnownLanguage> languages = e.getKnownLanguages();
                for(KnownLanguage l : languages){
                    if(l.getLanguageName().equals(language)){
                        l.setScoreOutOf100(score);
                        e.setKnownLanguages(languages);
                        handler.save(employees);
                        return "updated successfully";
                    }
                }
                KnownLanguage newLanguage = new KnownLanguage(language,score);
                languages.add(newLanguage);
                e.setKnownLanguages(languages);
                handler.save(employees);
                return "added successfully";
            }
        }
        return "id not found";
    }

    public List<Employee> searchEmployeeById(String employeeId)
    {
        employees = handler.load();
        if(employees == null || employees.isEmpty())
        {
            return new ArrayList<>();
        }
        List<Employee> matchingEmployees = new ArrayList<>();
        for( Employee employee : employees)
        {
            if(String.valueOf(employee.getEmployeeID()).contains(employeeId))
            {
                matchingEmployees.add(employee);
            }
        }
        return matchingEmployees;
    }

    public List<Employee> searchEmployeeByDesignation(String designation)
    {
        employees= handler.load();
        if(employees == null || employees.isEmpty())
        {
            return new ArrayList<>();
        }
        List<Employee> matchingEmployees = new ArrayList<>();
        for(Employee employee : employees)
        {
            if(designation != null && employee.getDesignation().toLowerCase().contains(designation.toLowerCase()))
            {
                matchingEmployees.add(employee);
            }
        }
        return matchingEmployees;
    }
}
